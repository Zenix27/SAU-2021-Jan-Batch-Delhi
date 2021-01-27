// Code quality Assignment :
// In this ts file, leave a short descriptive comment wherever you find a violation of the code quality practices as discussed in the session
// Also create acopy of this ts file which contains your correction(wherever possible) which corresponds to your comment left here.

//user defined modules should come after inbuilt default modules with a line gap in between
import { isReminderSelector } from '../../src/selectors/remSelector';
import { useSubscription } from '../../src/utils/Helper';

import { WatcherResult } from 'conduit-view';

//default modules from react libraries should come before the user defined modules imports. 
import { useEffect, useMemo, useRef, useState, useCallback } from 'react';

//leave one empty line between default modules and user defined modules imports (some code formatter does this automatic)

import {
  Result,
  NoteListQueryResult,
  GetNotesTabNoteListQuery,
  NoteListPlain,
} from 'ion-actions/note/getNotes';

import { selectedNoteSelector } from '../../src/selectors/notesSelector';


import { OnRowsRenderedNode } from '@node_modules/react-virtualized-sticky-tree';



//constants or identifiers should be in lower camel case
export const NoteListSize = 500;
//constants or identifiers should be in lower camel case
const AnotherCOnst = 0.7;
import { useSelector } from 'react-redux'; //all imports should come at the top 

//constant or identifiers should be defined together just after all the import statemments
const initialStartIndex = 0;
const initialStartKey = null;
const debugPagination = false;

export const UseNoteListSubscribedToParentNoteListInTheHomeViewOfTheWebApp = ( //should be in ower camel case & also very long function name 
  filters,sort,disablePagination,skip: boolean = false,   //no proper indentation
) => {
  const x = useSelector(isReminderSelector);
  const [currPage, setCurrPageKey] = useState<null | string>(null);  // setCurrPageKey - by convention set state method name should be: setCurrPage
  const [startIndex, setStartIndex] = useState(initialStartIndex);   // this is the right way to define set state method
  
//constants or identifiers should be in lower camel case
  const TOTALNOTES = useRef<number>(0);

//constants or identifiers should be in lower camel case
  const CURRENT_PAGE = useSubscription(
    GetNotesTabNoteListQuery,
    {
      noteFilters: filters,
    }
  );

  const isCurrentPageEmpty = CURRENT_PAGE.data?.list.length == 0;

  const numPriorItems = CURRENT_PAGE?.data?.numPriorItems ?? 0;

  //bad indentation not understandable
  const prevPageSize =
    numPriorItems < NoteListSize ? numPriorItems : NoteListSize;
  const shouldPrevPageLoad =
  CURRENT_PAGE.data != null && CURRENT_PAGE.data?.numPriorItems > 0 && !disablePagination;
  
  //bad indentation not understandable
  const randomFunction = useMemo(() => {
    let innerlist = CURRENT_PAGE.data
      .concat(
        addDebugInfo(CURRENT_PAGE?.data ?? [], {
          pageName: 'current',
          cached: CURRENT_PAGE === null,
        })
      )
    return innerlist;
  }, [
    disablePagination,
    startIndex,
    CURRENT_PAGE,
    isCurrentPageEmpty,
  ]);

  //bad indentation not readable
  const result = useMemo(     //call back function should be here just like the above function
    () => ({
      ...CURRENT_PAGE.data,
    }),
    [
      CURRENT_PAGE
    ]
  );
  return result;
};

function createPlaceholders(count: number, selectedID?: string | null): Result { 
  const placeholders: Array<Record<string, unknown>> = new Array(count);
  placeholders
    .fill(
      {
        id: selectedID,
        label: undefined,
        updated: undefined,
        debugInfo: { placeholder: true },
      },
      0,
      1
    )
    .fill(
      {
        id: undefined,
        label: undefined,
        updated: undefined,
        debugInfo: { placeholder: true },
      },
      1,
      count
    );
  return (placeholders as unknown) as Result;
}

//bad indentation not understandable
function addDebugInfo(
  list: Result,
  debugInfo: {
    pageName: PageName;
    cached: boolean;
  }
): Result {
  if (debugPagination) {
    return list.map(item => ({ ...item, debugInfo }));
  }
  return list;
}
