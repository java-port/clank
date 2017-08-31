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
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import static org.llvm.support.AdtsupportLlvmGlobals.llvm_is_multithreaded;
import static org.llvm.support.ValgrindGlobals.*;
import static org.llvm.support.impl.ManagedStaticStatics.StaticList;



/// ManagedStaticBase - Common base class for ManagedStatic instances.
//<editor-fold defaultstate="collapsed" desc="llvm::ManagedStaticBase">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", line = 39,
 FQN = "llvm::ManagedStaticBase", NM = "_ZN4llvm17ManagedStaticBaseE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -nm=_ZN4llvm17ManagedStaticBaseE")
//</editor-fold>
public class ManagedStaticBase {
/*protected:*/
  // This should only be used as a static variable, which guarantees that this
  // will be zero initialized.
  protected /*mutable */Object/*void P*/ Ptr;
  protected /*mutable */DestructorCallback /*P*/ DeleterFn;
  protected /*mutable *//*const*/ManagedStaticBase /*P*/ Next;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ManagedStaticBase::RegisterManagedStatic">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC, source = "${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp", line = 33,
   old_source = "${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp", old_line = 32,
   FQN = "llvm::ManagedStaticBase::RegisterManagedStatic", NM = "_ZNK4llvm17ManagedStaticBase21RegisterManagedStaticEPFPvvEPFvS1_E",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -nm=_ZNK4llvm17ManagedStaticBase21RegisterManagedStaticEPFPvvEPFvS1_E")
  //</editor-fold>
  @org.netbeans.api.annotations.common.SuppressWarnings(value = "ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD")  
  protected void RegisterManagedStatic(ConstructorCallback Creator, DestructorCallback Deleter) /*const*/ {
    if (llvm_is_multithreaded()) {
      llvm_acquire_global_lock();
      if (Ptr == null) {
        Object/*void P*/ tmp = $tryClone((Creator != null) ? Creator.$call(): null);
        AnnotateHappensBefore("${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp", 30, this);
        sys.MemoryFence();

        // This write is racy against the first read in the ManagedStatic
        // accessors. The race is benign because it does a second read after a
        // memory fence, at which point it isn't possible to get a partial value.
        AnnotateIgnoreWritesBegin("${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp", 36);
        Ptr = tmp;
        AnnotateIgnoreWritesEnd("${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp", 38);
        DeleterFn = Deleter;

        // Add to list of managed statics.
        Next = StaticList;
        StaticList = this;
      }

      llvm_release_global_lock();
    } else {
      synchronized (LOCK) {
        assert (Ptr == null && DeleterFn == null && Next == null) : "Partially initialized ManagedStatic!?";
        Ptr = $tryClone((Creator != null) ? Creator.$call(): null);
        DeleterFn = Deleter;

        // Add to list of managed statics.
        Next = StaticList;
        StaticList = this;
      }
    }
  }

/*public:*/
  /// isConstructed - Return true if this object has not been created yet.
  //<editor-fold defaultstate="collapsed" desc="llvm::ManagedStaticBase::isConstructed">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/ManagedStatic.h", line = 50,
   FQN = "llvm::ManagedStaticBase::isConstructed", NM = "_ZNK4llvm17ManagedStaticBase13isConstructedEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -nm=_ZNK4llvm17ManagedStaticBase13isConstructedEv")
  //</editor-fold>
  public boolean isConstructed() /*const*/ {
    return Ptr != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ManagedStaticBase::destroy">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp", line = 69,
   old_source = "${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp", old_line = 68,
   FQN = "llvm::ManagedStaticBase::destroy", NM = "_ZNK4llvm17ManagedStaticBase7destroyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ManagedStatic.cpp -nm=_ZNK4llvm17ManagedStaticBase7destroyEv")
  //</editor-fold>
  @org.netbeans.api.annotations.common.SuppressWarnings(value = "ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD")  
  public void destroy() /*const*/ {
    synchronized (LOCK) {
      assert ((DeleterFn != null)) : "ManagedStatic not initialized correctly!";
      assert (StaticList == this) : "Not destroyed in reverse order of construction?";
      // Unlink from list.
      StaticList = Next;
      Next = null;

      // Destroy memory.
      DeleterFn.$call(Ptr);

      // Cleanup.
      Ptr = null;
      DeleterFn = null;
    }
  }

  private static final Object LOCK = new Object();
}
