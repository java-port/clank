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

package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;


/// A specialization of DominatingValue for Address.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<Address>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3456,
 FQN="clang::CodeGen::DominatingValue<Address>", NM="_ZN5clang7CodeGen15DominatingValueINS0_7AddressEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_7AddressEEE")
//</editor-fold>
public class/*struct*/ DominatingValueAddress {
  // JAVA: typedef Address type
//  public final class type extends Address{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<Address>::saved_type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3459,
   FQN="clang::CodeGen::DominatingValue<Address>::saved_type", NM="_ZN5clang7CodeGen15DominatingValueINS0_7AddressEE10saved_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_7AddressEE10saved_typeE")
  //</editor-fold>
  public static class/*struct*/ saved_type {
    public PointerBoolPair<Value /*P*/ > SavedValue;
    public CharUnits Alignment;
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<Address>::saved_type::saved_type">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3459,
     FQN="clang::CodeGen::DominatingValue<Address>::saved_type::saved_type", NM="_ZN5clang7CodeGen15DominatingValueINS0_7AddressEE10saved_typeC1ERKS4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_7AddressEE10saved_typeC1ERKS4_")
    //</editor-fold>
    public /*inline*/ saved_type(final /*const*/ saved_type /*&*/ $Prm0) {
      // : SavedValue(.SavedValue), Alignment(.Alignment) 
      //START JInit
      this.SavedValue = new PointerBoolPair<Value /*P*/ >($Prm0.SavedValue);
      this.Alignment = new CharUnits($Prm0.Alignment);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<Address>::saved_type::saved_type">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3459,
     FQN="clang::CodeGen::DominatingValue<Address>::saved_type::saved_type", NM="_ZN5clang7CodeGen15DominatingValueINS0_7AddressEE10saved_typeC1EOS4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_7AddressEE10saved_typeC1EOS4_")
    //</editor-fold>
    public /*inline*/ saved_type(JD$Move _dparam, final saved_type /*&&*/$Prm0) {
      // : SavedValue(static_cast<saved_type &&>().SavedValue), Alignment(static_cast<saved_type &&>().Alignment) 
      //START JInit
      this.SavedValue = new PointerBoolPair<Value /*P*/ >(JD$Move.INSTANCE, $Prm0.SavedValue);
      this.Alignment = new CharUnits(JD$Move.INSTANCE, $Prm0.Alignment);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public saved_type(PointerBoolPair<Value> SavedValue, CharUnits Alignment) {
      this.SavedValue = SavedValue;
      this.Alignment = Alignment;
    }


    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "SavedValue=" + SavedValue // NOI18N
                + ", Alignment=" + Alignment; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<Address>::needsSaving">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3464,
   FQN="clang::CodeGen::DominatingValue<Address>::needsSaving", NM="_ZN5clang7CodeGen15DominatingValueINS0_7AddressEE11needsSavingES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_7AddressEE11needsSavingES2_")
  //</editor-fold>
  public static boolean needsSaving(Address value) {
    return DominatingLLVMValue.needsSaving(value.getPointer());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<Address>::save">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3467,
   FQN="clang::CodeGen::DominatingValue<Address>::save", NM="_ZN5clang7CodeGen15DominatingValueINS0_7AddressEE4saveERNS0_15CodeGenFunctionES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_7AddressEE4saveERNS0_15CodeGenFunctionES2_")
  //</editor-fold>
  public static saved_type save(final CodeGenFunction /*&*/ CGF, Address value) {
    return new saved_type(
      DominatingLLVMValue.save(CGF, value.getPointer()), 
      value.getAlignment());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::DominatingValue<Address>::restore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3471,
   FQN="clang::CodeGen::DominatingValue<Address>::restore", NM="_ZN5clang7CodeGen15DominatingValueINS0_7AddressEE7restoreERNS0_15CodeGenFunctionENS3_10saved_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN5clang7CodeGen15DominatingValueINS0_7AddressEE7restoreERNS0_15CodeGenFunctionENS3_10saved_typeE")
  //</editor-fold>
  public static Address restore(final CodeGenFunction /*&*/ CGF, saved_type value) {
    return new Address(DominatingLLVMValue.restore(CGF, new PointerBoolPair<Value /*P*/ >(value.SavedValue)), 
        new CharUnits(value.Alignment));
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
