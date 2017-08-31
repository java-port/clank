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

package org.clang.basic.vfs;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.basic.vfs.*;
import org.clang.basic.vfs.detail.DirIterImpl;

// end namespace detail

/// \brief An input iterator over the entries in a virtual path, similar to
/// llvm::sys::fs::directory_iterator.
//<editor-fold defaultstate="collapsed" desc="clang::vfs::directory_iterator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 123,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 115,
 FQN="clang::vfs::directory_iterator", NM="_ZN5clang3vfs18directory_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang3vfs18directory_iteratorE")
//</editor-fold>
public class directory_iterator<T extends DirIterImpl> implements Destructors.ClassWithDestructor, Native.NativeComparable<directory_iterator<T>> {
  private std.shared_ptr<T> Impl; // Input iterator semantics on copy
/*public:*/
  // Input iterator semantics on copy
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::directory_iterator::directory_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 127,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 119,
   FQN="clang::vfs::directory_iterator::directory_iterator", NM="_ZN5clang3vfs18directory_iteratorC1ESt10shared_ptrINS0_6detail11DirIterImplEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang3vfs18directory_iteratorC1ESt10shared_ptrINS0_6detail11DirIterImplEE")
  //</editor-fold>
  public directory_iterator(std.shared_ptr<DirIterImpl> I) {
    /* : Impl(std::move(I))*/ 
    //START JInit
    this.Impl = new std.shared_ptr(JD$Move.INSTANCE, I);
    //END JInit
    assert (Impl.get() != null) : "requires non-null implementation";
    if (!Impl.$arrow().CurrentEntry.isStatusKnown()) {
      Impl.reset(); // Normalize the end iterator to Impl == nullptr.
    }
  }

  
  /// \brief Construct an 'end' iterator.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::directory_iterator::directory_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 135,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 126,
   FQN="clang::vfs::directory_iterator::directory_iterator", NM="_ZN5clang3vfs18directory_iteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang3vfs18directory_iteratorC1Ev")
  //</editor-fold>
  public directory_iterator() {
    /* : Impl()*/ 
    //START JInit
    this.Impl = new std.shared_ptr<>();
    //END JInit
  }

  
  /// \brief Equivalent to operator++, with an error code.
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::directory_iterator::increment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 138,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 129,
   FQN="clang::vfs::directory_iterator::increment", NM="_ZN5clang3vfs18directory_iterator9incrementERSt10error_code",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang3vfs18directory_iterator9incrementERSt10error_code")
  //</editor-fold>
  public directory_iterator<T> /*&*/ increment(std.error_code /*&*/ EC) {
    assert (Impl.$bool()) : "attempting to increment past end";
    EC.$assignMove(Impl.$arrow().increment());
    if (EC.$bool() || !Impl.$arrow().CurrentEntry.isStatusKnown()) {
      Impl.reset(); // Normalize the end iterator to Impl == nullptr.
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::directory_iterator::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 146,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 137,
   FQN="clang::vfs::directory_iterator::operator*", NM="_ZNK5clang3vfs18directory_iteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang3vfs18directory_iteratordeEv")
  //</editor-fold>
  public /*const*/ Status /*&*/ $star() /*const*/ {
    return Impl.$arrow().CurrentEntry;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::directory_iterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 147,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 138,
   FQN="clang::vfs::directory_iterator::operator->", NM="_ZNK5clang3vfs18directory_iteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang3vfs18directory_iteratorptEv")
  //</editor-fold>
  public /*const*/ Status /*P*/ $arrow() /*const*/ {
    return $AddrOf(Impl.$arrow().CurrentEntry);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::vfs::directory_iterator::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 149,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 140,
   FQN="clang::vfs::directory_iterator::operator==", NM="_ZNK5clang3vfs18directory_iteratoreqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang3vfs18directory_iteratoreqERKS1_")
  //</editor-fold>
  public boolean $eq(/*const*/ directory_iterator<T> /*&*/ RHS) /*const*/ {
    if (Impl.$bool() && RHS.Impl.$bool()) {
      return Impl.$arrow().CurrentEntry.equivalent(RHS.Impl.$arrow().CurrentEntry);
    }
    return !Impl.$bool() && !RHS.Impl.$bool();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::directory_iterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 154,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 145,
   FQN="clang::vfs::directory_iterator::operator!=", NM="_ZNK5clang3vfs18directory_iteratorneERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang3vfs18directory_iteratorneERKS1_")
  //</editor-fold>
  public boolean $noteq(/*const*/ directory_iterator<T> /*&*/ RHS) /*const*/ {
    return !(/*Deref*/this.$eq(RHS));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::directory_iterator::directory_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 115,
   FQN="clang::vfs::directory_iterator::directory_iterator", NM="_ZN5clang3vfs18directory_iteratorC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang3vfs18directory_iteratorC1EOS1_")
  //</editor-fold>
  public /*inline*/ directory_iterator(JD$Move _dparam, directory_iterator<T> /*&&*/$Prm0) {
    /* : Impl(static_cast<directory_iterator &&>().Impl)*/ 
    //START JInit
    this.Impl = new std.shared_ptr<>(JD$Move.INSTANCE, $Prm0.Impl);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::directory_iterator::~directory_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 115,
   FQN="clang::vfs::directory_iterator::~directory_iterator", NM="_ZN5clang3vfs18directory_iteratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang3vfs18directory_iteratorD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Impl.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::vfs::directory_iterator::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 115,
   FQN="clang::vfs::directory_iterator::operator=", NM="_ZN5clang3vfs18directory_iteratoraSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang3vfs18directory_iteratoraSERKS1_")
  //</editor-fold>
  public /*inline*/ directory_iterator<T> /*&*/ $assign(/*const*/ directory_iterator<T> /*&*/ $Prm0) {
    this.Impl.$assign($Prm0.Impl);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::vfs::directory_iterator::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 115,
   FQN="clang::vfs::directory_iterator::operator=", NM="_ZN5clang3vfs18directory_iteratoraSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs18directory_iteratoraSEOS1_")
  //</editor-fold>
  public /*inline*/ directory_iterator<T> /*&*/ $assignMove(directory_iterator<T> /*&&*/$Prm0) {
    this.Impl.$assignMove($Prm0.Impl);
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::vfs::directory_iterator::directory_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/VirtualFileSystem.h", old_line = 115,
   FQN="clang::vfs::directory_iterator::directory_iterator", NM="_ZN5clang3vfs18directory_iteratorC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VirtualFileSystem.cpp -nm=_ZN5clang3vfs18directory_iteratorC1ERKS1_")
  //</editor-fold>
  public /*inline*/ directory_iterator(/*const*/ directory_iterator<T> /*&*/ $Prm0) {
    /* : Impl(.Impl)*/ 
    //START JInit
    this.Impl = new std.shared_ptr<>($Prm0.Impl);
    //END JInit
  }

  
  public String toString() {
    return "" + "Impl=" + Impl; // NOI18N
  }
}
