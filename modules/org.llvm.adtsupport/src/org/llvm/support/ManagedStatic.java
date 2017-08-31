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

package org.llvm.support;

import org.llvm.support.sys.sys;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.llvm.support.AdtsupportLlvmGlobals.llvm_is_multithreaded;
import static org.llvm.support.ValgrindGlobals.AnnotateHappensAfter;


/*template <class C> TEMPLATE*/

/// ManagedStatic - This transparently changes the behavior of global statics to
/// be lazily constructed on demand (good for reducing startup times of dynamic
/// libraries that link in LLVM components) and for making destruction be
/// explicit through the llvm_shutdown() function call.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ManagedStatic">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", line = 60,
 FQN = "llvm::ManagedStatic", NM = "_ZN4llvm13ManagedStaticE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -nm=_ZN4llvm13ManagedStaticE")
//</editor-fold>
public class ManagedStatic</*class*/ C>  extends /*public*/ ManagedStaticBase {
  private final ManagedStaticInfo<C> info;

/*public:*/
  public ManagedStatic(ManagedStaticInfo<C> info) {
    assert info != null;
    this.info = info;
  }
  
  // Accessors.
  //<editor-fold defaultstate="collapsed" desc="llvm::ManagedStatic::operator*">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", line = 65,
   FQN = "llvm::ManagedStatic::operator*", NM = "_ZN4llvm13ManagedStaticdeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -nm=_ZN4llvm13ManagedStaticdeEv")
  //</editor-fold>
  public C /*&*/ $star() {
    Object/*void P*/ tmp = Ptr;
    if (llvm_is_multithreaded()) {
      sys.MemoryFence();
    }
    if (!(tmp != null)) {
      RegisterManagedStatic(info.object_creator(), info.object_deleter());
    }
    AnnotateHappensAfter("${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", 69, this);
    
    return /*Deref*/(/*static_cast*/C /*P*/ )(Ptr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ManagedStatic::operator->">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", line = 73,
   FQN = "llvm::ManagedStatic::operator->", NM = "_ZN4llvm13ManagedStaticptEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -nm=_ZN4llvm13ManagedStaticptEv")
  //</editor-fold>
  public C /*P*/ $arrow() {
    Object/*void P*/ tmp = $tryClone(Ptr);
    if (llvm_is_multithreaded()) {
      sys.MemoryFence();
    }
    if (!(tmp != null)) {
      RegisterManagedStatic(info.object_creator(), info.object_deleter());
    }
    AnnotateHappensAfter("${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", 77, this);

    return (/*static_cast*/C /*P*/ )(Ptr);
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::ManagedStatic::operator*">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", line = 81,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -filter=llvm::ManagedStatic::operator*")
//  //</editor-fold>
//  public /*const*/C /*&*/ $star() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::ManagedStatic::operator->">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", line = 89,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -filter=llvm::ManagedStatic::operator->")
//  //</editor-fold>
//  public /*const*/C /*P*/ $arrow() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

}
