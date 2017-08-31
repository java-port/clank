/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.basic;

import java.util.Iterator;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// \brief Used to hold and unique data used to represent \#line information.
//<editor-fold defaultstate="collapsed" desc="clang::LineTableInfo">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 77,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", old_line = 77,
 FQN = "clang::LineTableInfo", NM = "_ZN5clang13LineTableInfoE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13LineTableInfoE")
//</editor-fold>
public class LineTableInfo  implements Iterable<std.pairIntType</*const*//*FileID,*/std.vector<LineEntry/*,default_cls_allocator*/>>>, Destructors.ClassWithDestructor {
  /// \brief Map used to assign unique IDs to filenames in \#line directives. 
  ///
  /// This allows us to unique the filenames that
  /// frequently reoccur and reference them with indices.  FilenameIDs holds
  /// the mapping from string -> ID, and FilenamesByID holds the mapping of ID
  /// to string.
  private StringMapUInt/*<BumpPtrAllocator>*/ FilenameIDs;
  private std.vector<StringMapEntryUInt/*P*/ > FilenamesByID;
  
  /// \brief Map from FileIDs to a list of line entries (sorted by the offset
  /// at which they occur in the file).
  private std.mapIntType</*FileID, */std.vector<LineEntry> > LineEntries;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LineTableInfo::LineTableInfo">
  @Converted(kind = Converted.Kind.MANUAL, 
   optimized = Converted.Optimization.VALUE_TYPE/*null def-value*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 77,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", old_line = 91,
   FQN="clang::LineTableInfo::LineTableInfo", NM="_ZN5clang13LineTableInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13LineTableInfoC1Ev")
  //</editor-fold>
  public /*inline*/ LineTableInfo() {
    /* : FilenameIDs(), FilenamesByID(), LineEntries()*/ 
    //START JInit
    this.FilenameIDs = new StringMapUInt(0);
    this.FilenamesByID = new std.vector<StringMapEntryUInt/*P*/ >(((StringMapEntryUInt/*P*/) null));
    this.LineEntries = new std.mapIntType</*FileID,*/ std.vector<LineEntry> >(new std.vector((LineEntry)null/*PERF: new LineEntry()*/));
    //END JInit
    /// \brief Used to hold and unique data used to represent \#line information.
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LineTableInfo::clear">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 91,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", old_line = 94,
   FQN = "clang::LineTableInfo::clear", NM = "_ZN5clang13LineTableInfo5clearEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13LineTableInfo5clearEv")
  //</editor-fold>
  public void clear() {
    FilenameIDs.clear();
    FilenamesByID.clear();
    LineEntries.clear();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LineTableInfo::~LineTableInfo">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 77,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", old_line = 100,
   FQN="clang::LineTableInfo::~LineTableInfo", NM="_ZN5clang13LineTableInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13LineTableInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    /// \brief Used to hold and unique data used to represent \#line information.
    //START JDestroy
    LineEntries.$destroy();
    FilenamesByID.$destroy();
    FilenameIDs.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LineTableInfo::getLineTableFilenameID">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 179,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 179,
   FQN = "clang::LineTableInfo::getLineTableFilenameID", NM = "_ZN5clang13LineTableInfo22getLineTableFilenameIDEN4llvm9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13LineTableInfo22getLineTableFilenameIDEN4llvm9StringRefE")
  //</editor-fold>
  public /*uint*/int getLineTableFilenameID(StringRef Name) {
    // Look up the filename in the string table, returning the pre-existing value
    // if it exists.
    StringMapEntryUInt/*&*/ Entry = FilenameIDs.GetOrCreateValue(Name, ~0/*U*/);
    if (Entry.getValue() != ~0/*U*/) {
      return Entry.getValue();
    }
    
    // Otherwise, assign this the next available ID.
    Entry.setValue(FilenamesByID.size());
    FilenamesByID.push_back($AddrOf(Entry));
    return FilenamesByID.size() - 1;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LineTableInfo::getFilename">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 98,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", old_line = 103,
   FQN = "clang::LineTableInfo::getFilename", NM = "_ZNK5clang13LineTableInfo11getFilenameEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13LineTableInfo11getFilenameEj")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getFilename(/*uint*/int ID) /*const*/ {
    assert (ID < FilenamesByID.size()) : "Invalid FilenameID";
    return FilenamesByID.$at(ID).getKeyData();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LineTableInfo::getNumFilenames">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 102,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", old_line = 107,
   FQN = "clang::LineTableInfo::getNumFilenames", NM = "_ZNK5clang13LineTableInfo15getNumFilenamesEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZNK5clang13LineTableInfo15getNumFilenamesEv")
  //</editor-fold>
  public /*uint*/int getNumFilenames() /*const*/ {
    return FilenamesByID.size();
  }

  
  /// AddLineNote - Add a line note to the line table that indicates that there
  /// is a \#line at the specified FID/Offset location which changes the presumed
  /// location to LineNo/FilenameID.
  //<editor-fold defaultstate="collapsed" desc="clang::LineTableInfo::AddLineNote">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 190,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 190,
   FQN = "clang::LineTableInfo::AddLineNote", NM = "_ZN5clang13LineTableInfo11AddLineNoteENS_6FileIDEjji",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13LineTableInfo11AddLineNoteENS_6FileIDEjji")
  //</editor-fold>
  public void AddLineNote(FileID FID, /*uint*/int Offset, /*uint*/int LineNo, int FilenameID) {
    AddLineNote(FID.ID, Offset, LineNo, FilenameID);
  }
  public void AddLineNote(/*FileID*/int FID, /*uint*/int Offset, /*uint*/int LineNo, int FilenameID) {
    std.vector<LineEntry> /*&*/ Entries = LineEntries.$at(FID);
    assert ((Entries.empty() || Entries.back().FileOffset < Offset)) : "Adding line entries out of order!";
    
    SrcMgr.CharacteristicKind Kind = SrcMgr.CharacteristicKind.C_User;
    /*uint*/int IncludeOffset = 0;
    if (!Entries.empty()) {
      // If this is a '#line 4' after '#line 42 "foo.h"', make sure to remember
      // that we are still in "foo.h".
      if (FilenameID == -1) {
        FilenameID = Entries.back().FilenameID;
      }
      
      // If we are after a line marker that switched us to system header mode, or
      // that set #include information, preserve it.
      Kind = Entries.back().FileKind;
      IncludeOffset = Entries.back().IncludeOffset;
    }
    
    Entries.push_back(LineEntry.get(Offset, LineNo, FilenameID, Kind, IncludeOffset));
  }

  
  /// AddLineNote This is the same as the previous version of AddLineNote, but is
  /// used for GNU line markers.  If EntryExit is 0, then this doesn't change the
  /// presumed \#include stack.  If it is 1, this is a file entry, if it is 2 then
  /// this is a file exit.  FileKind specifies whether this is a system header or
  /// extern C system header.
  //<editor-fold defaultstate="collapsed" desc="clang::LineTableInfo::AddLineNote">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 221,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 221,
   FQN = "clang::LineTableInfo::AddLineNote", NM = "_ZN5clang13LineTableInfo11AddLineNoteENS_6FileIDEjjijNS_6SrcMgr18CharacteristicKindE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13LineTableInfo11AddLineNoteENS_6FileIDEjjijNS_6SrcMgr18CharacteristicKindE")
  //</editor-fold>
  public void AddLineNote(FileID FID, /*uint*/int Offset, /*uint*/int LineNo, int FilenameID, /*uint*/int EntryExit, SrcMgr.CharacteristicKind FileKind) {
    AddLineNote(FID.ID, Offset, LineNo, FilenameID, EntryExit, FileKind);
  }
  public void AddLineNote(/*FileID*/int FID, /*uint*/int Offset, /*uint*/int LineNo, int FilenameID, /*uint*/int EntryExit, SrcMgr.CharacteristicKind FileKind) {
    assert (FilenameID != -1) : "Unspecified filename should use other accessor";
    
    std.vector<LineEntry> /*&*/ Entries = LineEntries.$at(FID);
    assert ((Entries.empty() || Entries.back().FileOffset < Offset)) : "Adding line entries out of order!";
    
    /*uint*/int IncludeOffset = 0;
    if (EntryExit == 0) { // No #include stack change.
      IncludeOffset = Entries.empty() ? 0 : Entries.back().IncludeOffset;
    } else if (EntryExit == 1) {
      IncludeOffset = Offset - 1;
    } else if (EntryExit == 2) {
      assert (!Entries.empty() && (Entries.back().IncludeOffset != 0)) : "PPDirectives should have caught case when popping empty include stack";
      
      // Get the include loc of the last entries' include loc as our include loc.
      IncludeOffset = 0;
      {
        /*const*/LineEntry /*P*/ PrevEntry = FindNearestLineEntry(FID, Entries.back().IncludeOffset);
        if ((PrevEntry != null)) {
          IncludeOffset = PrevEntry.IncludeOffset;
        }
      }
    }
    
    Entries.push_back(LineEntry.get(Offset, LineNo, FilenameID, FileKind, IncludeOffset));
  }

  
  /// \brief Find the line entry nearest to FID that is before it.
  ///
  /// If there is no line entry before \p Offset in \p FID, returns null.
  
  /// FindNearestLineEntry - Find the line entry nearest to FID that is before
  /// it.  If there is no line entry before Offset in FID, return null.
  //<editor-fold defaultstate="collapsed" desc="clang::LineTableInfo::FindNearestLineEntry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 255,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 255,
   FQN = "clang::LineTableInfo::FindNearestLineEntry", NM = "_ZN5clang13LineTableInfo20FindNearestLineEntryENS_6FileIDEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13LineTableInfo20FindNearestLineEntryENS_6FileIDEj")
  //</editor-fold>
  public /*const*/LineEntry /*P*/ FindNearestLineEntry(FileID FID, /*uint*/int Offset) {
    return FindNearestLineEntry(FID.ID, Offset);
  }
  public /*const*/LineEntry /*P*/ FindNearestLineEntry(/*FileID*/int FID, /*uint*/int Offset) {
    /*const*/std.vector<LineEntry> /*&*/ Entries = LineEntries.$at(FID);
    assert (!Entries.empty()) : "No #line entries for this FID after all!";
    
    // It is very common for the query to be after the last #line, check this
    // first.
    if (Entries.back().FileOffset <= Offset) {
      return $AddrOf(Entries.back());
    }
    
    // Do a binary search to find the maximal element that is still before Offset.
    std.vector.iterator<LineEntry> I = std.upper_bound(Entries.begin(), Entries.end(), Offset);
    if ($eq___normal_iterator(I, Entries.begin())) {
      return null;
    }
    return $AddrOf(I.$preDec().$star());
  }

  
  // Low-level access
  /*typedef std::map<FileID, std::vector<LineEntry> >::iterator iterator*/
  //public final class iterator extends std.map.iterator<FileID, std.vector<LineEntry> >{ };
  //<editor-fold defaultstate="collapsed" desc="clang::LineTableInfo::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 118,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", old_line = 123,
   FQN = "clang::LineTableInfo::begin", NM = "_ZN5clang13LineTableInfo5beginEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13LineTableInfo5beginEv")
  //</editor-fold>
  public std.mapIntType.iterator</*FileID,*/std.vector<LineEntry> > begin() {
    return LineEntries.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LineTableInfo::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 119,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", old_line = 124,
   FQN = "clang::LineTableInfo::end", NM = "_ZN5clang13LineTableInfo3endEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13LineTableInfo3endEv")
  //</editor-fold>
  public std.mapIntType.iterator</*FileID,*/std.vector<LineEntry> > end() {
    return LineEntries.end();
  }

  
  /// \brief Add a new line entry that has already been encoded into
  /// the internal representation of the line table.
  
  /// \brief Add a new line entry that has already been encoded into
  /// the internal representation of the line table.
  //<editor-fold defaultstate="collapsed" desc="clang::LineTableInfo::AddEntry">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", line = 274,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp", old_line = 274,
   FQN = "clang::LineTableInfo::AddEntry", NM = "_ZN5clang13LineTableInfo8AddEntryENS_6FileIDERKSt6vectorINS_9LineEntryESaIS3_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clang13LineTableInfo8AddEntryENS_6FileIDERKSt6vectorINS_9LineEntryESaIS3_EE")
  //</editor-fold>
  public void AddEntry(FileID FID, /*const*/std.vector<LineEntry> /*&*/ Entries) {
    AddEntry(FID.ID, Entries);
  }
  public void AddEntry(/*FileID*/int FID, /*const*/std.vector<LineEntry> /*&*/ Entries) {
    LineEntries.$at(FID).$assign(Entries);
  }

  @Override
  public Iterator<std.pairIntType</*const*//*FileID,*/std.vector<LineEntry/*,default_cls_allocator*/>>> iterator() {
    return new JavaIterator(begin(), end());
  }
}
