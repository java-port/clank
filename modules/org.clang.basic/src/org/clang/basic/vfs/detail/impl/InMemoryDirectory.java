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

package org.clang.basic.vfs.detail.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.vfs.*;

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::InMemoryDirectory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 460,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 443,
 FQN="clang::vfs::detail::InMemoryDirectory", NM="_ZN5clang3vfs6detail17InMemoryDirectoryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail17InMemoryDirectoryE")
//</editor-fold>
public class InMemoryDirectory extends /*public*/ InMemoryNode implements Destructors.ClassWithDestructor {
  private std.mapTypeType<std.string, std.unique_ptr<InMemoryNode> > Entries;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::InMemoryDirectory::InMemoryDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 464,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 447,
   FQN="clang::vfs::detail::InMemoryDirectory::InMemoryDirectory", NM="_ZN5clang3vfs6detail17InMemoryDirectoryC1ENS0_6StatusE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail17InMemoryDirectoryC1ENS0_6StatusE")
  //</editor-fold>
  public InMemoryDirectory(Status Stat) {
    /* : InMemoryNode(std::move(Stat), IME_Directory), Entries()*/ 
    //START JInit
    /*ExprWithCleanups*/super(new Status(JD$Move.INSTANCE, std.move(Stat)), InMemoryNodeKind.IME_Directory);
    this.Entries = new std.mapTypeType<std.string, std.unique_ptr<InMemoryNode> >(new std.unique_ptr<InMemoryNode>());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::InMemoryDirectory::getChild">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 466,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 449,
   FQN="clang::vfs::detail::InMemoryDirectory::getChild", NM="_ZN5clang3vfs6detail17InMemoryDirectory8getChildEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail17InMemoryDirectory8getChildEN4llvm9StringRefE")
  //</editor-fold>
  public InMemoryNode /*P*/ getChild(StringRef Name) {
    std.mapTypeType.iterator</*const*/std.string, unique_ptr<InMemoryNode>> I = Entries.find(Name.$string());
    if (I.$noteq(Entries.end())) {
      return I.$arrow().second.get();
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::InMemoryDirectory::addChild">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 472,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 455,
   FQN="clang::vfs::detail::InMemoryDirectory::addChild", NM="_ZN5clang3vfs6detail17InMemoryDirectory8addChildEN4llvm9StringRefESt10unique_ptrINS1_12InMemoryNodeESt14default_deleteIS6_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail17InMemoryDirectory8addChildEN4llvm9StringRefESt10unique_ptrINS1_12InMemoryNodeESt14default_deleteIS6_EE")
  //</editor-fold>
  public InMemoryNode /*P*/ addChild(StringRef Name, std.unique_ptr<InMemoryNode> Child) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // JAVA: called StringRef.$string and use $T$RR for insert
      return $c$.clean(Entries.insert$T$RR($c$.track(make_pair(Name.$string(), $Move(std.move(Child))))).
          first.$arrow().second.get());
    } finally {
      $c$.$destroy();
    }
  }

  
  /*typedef decltype(Entries)::const_iterator const_iterator*/
//  public final class const_iterator extends _Rb_tree_const_iterator<pair</*const*/std.string, unique_ptr<InMemoryNode, default_delete<InMemoryNode> > > >{ };
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::InMemoryDirectory::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 478,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 461,
   FQN="clang::vfs::detail::InMemoryDirectory::begin", NM="_ZNK5clang3vfs6detail17InMemoryDirectory5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6detail17InMemoryDirectory5beginEv")
  //</editor-fold>
  public std.mapTypeType.iterator</*const*/std.string, unique_ptr<InMemoryNode>> begin() /*const*/ {
    return Entries.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::InMemoryDirectory::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 479,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 462,
   FQN="clang::vfs::detail::InMemoryDirectory::end", NM="_ZNK5clang3vfs6detail17InMemoryDirectory3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6detail17InMemoryDirectory3endEv")
  //</editor-fold>
  public std.mapTypeType.iterator</*const*/std.string, unique_ptr<InMemoryNode>> end() /*const*/ {
    return Entries.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::InMemoryDirectory::toString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 481,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 464,
   FQN="clang::vfs::detail::InMemoryDirectory::toString", NM="_ZNK5clang3vfs6detail17InMemoryDirectory8toStringEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZNK5clang3vfs6detail17InMemoryDirectory8toStringEj")
  //</editor-fold>
  @Override public std.string __toString(/*uint*/int Indent) /*const*//* override*/ {
    std.string Result = ($add_Twine($add_Twine(new Twine(new std.string(Indent, $$SPACE)), new Twine(getStatus().getName())), new Twine(/*KEEP_STR*/$LF))).str();
    for (/*const*/ pair</*const*/std.string, unique_ptr<InMemoryNode> > /*&*/ Entry : Entries) {
      Result.$addassign(Entry.second.$arrow().__toString(Indent + 2));
    }
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::InMemoryDirectory::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 489,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 472,
   FQN="clang::vfs::detail::InMemoryDirectory::classof", NM="_ZN5clang3vfs6detail17InMemoryDirectory7classofEPKNS1_12InMemoryNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail17InMemoryDirectory7classofEPKNS1_12InMemoryNodeE")
  //</editor-fold>
  public static boolean classof(/*const*/ InMemoryNode /*P*/ N) {
    return N.getKind() == InMemoryNodeKind.IME_Directory;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::detail::InMemoryDirectory::~InMemoryDirectory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", line = 460,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp", old_line = 443,
   FQN="clang::vfs::detail::InMemoryDirectory::~InMemoryDirectory", NM="_ZN5clang3vfs6detail17InMemoryDirectoryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs6detail17InMemoryDirectoryD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    Entries.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "InMemoryDirectory:{\n" + super.toString() + "}";
  }
}
