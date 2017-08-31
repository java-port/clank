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

package org.clang.basic.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingDirectoryEntry">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 721,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 704,
 FQN="(anonymous namespace)::RedirectingDirectoryEntry", NM="_ZN12_GLOBAL__N_125RedirectingDirectoryEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_125RedirectingDirectoryEntryE")
//</editor-fold>
public class RedirectingDirectoryEntry extends /*public*/ Entry implements Destructors.ClassWithDestructor {
  private std.vector<std.unique_ptr<Entry> > Contents;
  private Status S;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingDirectoryEntry::RedirectingDirectoryEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 726,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 709,
   FQN="(anonymous namespace)::RedirectingDirectoryEntry::RedirectingDirectoryEntry", NM="_ZN12_GLOBAL__N_125RedirectingDirectoryEntryC1EN4llvm9StringRefESt6vectorISt10unique_ptrINS_5EntryESt14default_deleteIS5_EESaIS8_EEN5clang3vfs6StatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_125RedirectingDirectoryEntryC1EN4llvm9StringRefESt6vectorISt10unique_ptrINS_5EntryESt14default_deleteIS5_EESaIS8_EEN5clang3vfs6StatusE")
  //</editor-fold>
  public RedirectingDirectoryEntry(StringRef Name, 
      std.vector<std.unique_ptr<Entry> > Contents, 
      Status S) {
    /* : Entry(EK_Directory, Name), Contents(std::move(Contents)), S(std::move(S))*/ 
    //START JInit
    super(EntryKind.EK_Directory, new StringRef(Name));
    this.Contents = new std.vector<std.unique_ptr<Entry> >(JD$Move.INSTANCE, std.move(Contents));
    this.S = new Status(JD$Move.INSTANCE, std.move(S));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingDirectoryEntry::RedirectingDirectoryEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 731,
   FQN="(anonymous namespace)::RedirectingDirectoryEntry::RedirectingDirectoryEntry", NM="_ZN12_GLOBAL__N_125RedirectingDirectoryEntryC1EN4llvm9StringRefEN5clang3vfs6StatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_125RedirectingDirectoryEntryC1EN4llvm9StringRefEN5clang3vfs6StatusE")
  //</editor-fold>
  public RedirectingDirectoryEntry(StringRef Name, Status S) {
    /* : Entry(EK_Directory, Name), Contents(), S(std::move(S))*/ 
    //START JInit
    super(EntryKind.EK_Directory, new StringRef(Name));
    this.Contents = new std.vector<std.unique_ptr<Entry> >(new std.unique_ptr<Entry>());
    this.S = new Status(JD$Move.INSTANCE, std.move(S));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingDirectoryEntry::getStatus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 733,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 714,
   FQN="(anonymous namespace)::RedirectingDirectoryEntry::getStatus", NM="_ZN12_GLOBAL__N_125RedirectingDirectoryEntry9getStatusEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_125RedirectingDirectoryEntry9getStatusEv")
  //</editor-fold>
  public Status getStatus() {
    return new Status(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingDirectoryEntry::addContent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 734,
   FQN="(anonymous namespace)::RedirectingDirectoryEntry::addContent", NM="_ZN12_GLOBAL__N_125RedirectingDirectoryEntry10addContentESt10unique_ptrINS_5EntryESt14default_deleteIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_125RedirectingDirectoryEntry10addContentESt10unique_ptrINS_5EntryESt14default_deleteIS2_EE")
  //</editor-fold>
  public void addContent(std.unique_ptr<Entry> Content) {
    Contents.push_back_T$RR(std.move(Content));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingDirectoryEntry::getLastContent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 737,
   FQN="(anonymous namespace)::RedirectingDirectoryEntry::getLastContent", NM="_ZNK12_GLOBAL__N_125RedirectingDirectoryEntry14getLastContentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK12_GLOBAL__N_125RedirectingDirectoryEntry14getLastContentEv")
  //</editor-fold>
  public Entry /*P*/ getLastContent() /*const*/ {
    return Contents.back().get();
  }

  /*typedef decltype(Contents)::iterator iterator*/
//  public final class iterator extends std.vector.iterator<unique_ptr<Entry>>{ };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingDirectoryEntry::contents_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 739,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 716,
   FQN="(anonymous namespace)::RedirectingDirectoryEntry::contents_begin", NM="_ZN12_GLOBAL__N_125RedirectingDirectoryEntry14contents_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_125RedirectingDirectoryEntry14contents_beginEv")
  //</editor-fold>
  public std.vector.iterator<unique_ptr<Entry>> contents_begin() {
    return Contents.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingDirectoryEntry::contents_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 740,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 717,
   FQN="(anonymous namespace)::RedirectingDirectoryEntry::contents_end", NM="_ZN12_GLOBAL__N_125RedirectingDirectoryEntry12contents_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_125RedirectingDirectoryEntry12contents_endEv")
  //</editor-fold>
  public std.vector.iterator<unique_ptr<Entry>> contents_end() {
    return Contents.end();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingDirectoryEntry::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 741,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 718,
   FQN="(anonymous namespace)::RedirectingDirectoryEntry::classof", NM="_ZN12_GLOBAL__N_125RedirectingDirectoryEntry7classofEPKNS_5EntryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_125RedirectingDirectoryEntry7classofEPKNS_5EntryE")
  //</editor-fold>
  public static boolean classof(/*const*/ Entry /*P*/ E) {
    return E.getKind() == EntryKind.EK_Directory;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RedirectingDirectoryEntry::~RedirectingDirectoryEntry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 721,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 704,
   FQN="(anonymous namespace)::RedirectingDirectoryEntry::~RedirectingDirectoryEntry", NM="_ZN12_GLOBAL__N_125RedirectingDirectoryEntryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN12_GLOBAL__N_125RedirectingDirectoryEntryD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    S.$destroy();
    Contents.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "Contents=" + Contents // NOI18N
              + ", S=" + S // NOI18N
              + super.toString(); // NOI18N
  }
}
