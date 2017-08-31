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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;


/// Represents a location in source code.
//<editor-fold defaultstate="collapsed" desc="llvm::SMLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 23,
 FQN="llvm::SMLoc", NM="_ZN4llvm5SMLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm5SMLocE")
//</editor-fold>
public class SMLoc implements Native.NativeComparable<SMLoc> {
  private /*const*/char$ptr/*char P*/ Ptr;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SMLoc::SMLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 27,
   FQN="llvm::SMLoc::SMLoc", NM="_ZN4llvm5SMLocC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm5SMLocC1Ev")
  //</editor-fold>
  public SMLoc() {
    // : Ptr(null) 
    //START JInit
    this.Ptr = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SMLoc::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 29,
   FQN="llvm::SMLoc::isValid", NM="_ZNK4llvm5SMLoc7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK4llvm5SMLoc7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return $noteq_ptr(Ptr, null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SMLoc::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 31,
   FQN="llvm::SMLoc::operator==", NM="_ZNK4llvm5SMLoceqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK4llvm5SMLoceqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ SMLoc /*&*/ RHS) /*const*/ {
    return $eq_ptr(RHS.Ptr, Ptr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMLoc::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 32,
   FQN="llvm::SMLoc::operator!=", NM="_ZNK4llvm5SMLocneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK4llvm5SMLocneERKS0_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ SMLoc /*&*/ RHS) /*const*/ {
    return $noteq_ptr(RHS.Ptr, Ptr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SMLoc::getPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 34,
   FQN="llvm::SMLoc::getPointer", NM="_ZNK4llvm5SMLoc10getPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZNK4llvm5SMLoc10getPointerEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getPointer() /*const*/ {
    return Ptr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SMLoc::getFromPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 36,
   FQN="llvm::SMLoc::getFromPointer", NM="_ZN4llvm5SMLoc14getFromPointerEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm5SMLoc14getFromPointerEPKc")
  //</editor-fold>
  public static SMLoc getFromPointer(/*const*/char$ptr/*char P*/ Ptr) {
    SMLoc L/*J*/= new SMLoc();
    L.Ptr = $tryClone(Ptr);
    return L;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMLoc::SMLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 23,
   FQN="llvm::SMLoc::SMLoc", NM="_ZN4llvm5SMLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm5SMLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SMLoc(final /*const*/ SMLoc /*&*/ $Prm0) {
    // : Ptr(.Ptr) 
    //START JInit
    this.Ptr = $tryClone($Prm0.Ptr);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMLoc::SMLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 23,
   FQN="llvm::SMLoc::SMLoc", NM="_ZN4llvm5SMLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm5SMLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ SMLoc(JD$Move _dparam, final SMLoc /*&&*/$Prm0) {
    // : Ptr(static_cast<SMLoc &&>().Ptr) 
    //START JInit
    this.Ptr = $tryClone($Prm0.Ptr);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMLoc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 23,
   FQN="llvm::SMLoc::operator=", NM="_ZN4llvm5SMLocaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm5SMLocaSERKS0_")
  //</editor-fold>
  public /*inline*/ SMLoc /*&*/ $assign(final /*const*/ SMLoc /*&*/ $Prm0) {
    this.Ptr = $tryClone($Prm0.Ptr);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SMLoc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/SMLoc.h", line = 23,
   FQN="llvm::SMLoc::operator=", NM="_ZN4llvm5SMLocaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ObjCMT.cpp -nm=_ZN4llvm5SMLocaSEOS0_")
  //</editor-fold>
  public /*inline*/ SMLoc /*&*/ $assignMove(final SMLoc /*&&*/$Prm0) {
    this.Ptr = $tryClone($Prm0.Ptr);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Ptr=" + Ptr; // NOI18N
  }
}
