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

package org.llvm.ir.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.adt.ADTFunctionPointers.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.*;
import org.llvm.ir.Metadata.*;
import org.llvm.ir.intrinsic.*;
import static org.llvm.ir.java.IRFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.cl.*;
import org.llvm.ir.java.IRJavaDifferentiators.*;
import org.llvm.ir.java.IRMemberPointers.*;
import org.llvm.ir.java.*;
import org.llvm.pass.*;
import org.llvm.support.dwarf.Tag;
import org.llvm.support.sys.SmartRWMutex;
import org.llvm.ir.java.cst_pred_ty_Predicate;
import org.llvm.ir.legacy.PassManagerBase;
import org.llvm.ir.PassManagerGlobals.*;
import org.llvm.ir.java.MDNodeKeyImpl;
import static org.llvm.adt.HashingGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::InlineAsmKeyType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 394,
 FQN="llvm::InlineAsmKeyType", NM="_ZN4llvm16InlineAsmKeyTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm16InlineAsmKeyTypeE")
//</editor-fold>
public class/*struct*/ InlineAsmKeyType implements Native.NativeComparable<InlineAsmKeyType> {
  public StringRef AsmString;
  public StringRef Constraints;
  public FunctionType /*P*/ FTy;
  public boolean HasSideEffects;
  public boolean IsAlignStack;
  public InlineAsm.AsmDialect AsmDialect;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsmKeyType::InlineAsmKeyType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 402,
   FQN="llvm::InlineAsmKeyType::InlineAsmKeyType", NM="_ZN4llvm16InlineAsmKeyTypeC1ENS_9StringRefES1_PNS_12FunctionTypeEbbNS_9InlineAsm10AsmDialectE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm16InlineAsmKeyTypeC1ENS_9StringRefES1_PNS_12FunctionTypeEbbNS_9InlineAsm10AsmDialectE")
  //</editor-fold>
  public InlineAsmKeyType(StringRef AsmString, StringRef Constraints, 
      FunctionType /*P*/ FTy, boolean HasSideEffects, boolean IsAlignStack, 
      InlineAsm.AsmDialect AsmDialect) {
    // : AsmString(AsmString), Constraints(Constraints), FTy(FTy), HasSideEffects(HasSideEffects), IsAlignStack(IsAlignStack), AsmDialect(AsmDialect) 
    //START JInit
    this.AsmString = new StringRef(AsmString);
    this.Constraints = new StringRef(Constraints);
    this.FTy = FTy;
    this.HasSideEffects = HasSideEffects;
    this.IsAlignStack = IsAlignStack;
    this.AsmDialect = AsmDialect;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsmKeyType::InlineAsmKeyType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 408,
   FQN="llvm::InlineAsmKeyType::InlineAsmKeyType", NM="_ZN4llvm16InlineAsmKeyTypeC1EPKNS_9InlineAsmERNS_15SmallVectorImplIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm16InlineAsmKeyTypeC1EPKNS_9InlineAsmERNS_15SmallVectorImplIPNS_8ConstantEEE")
  //</editor-fold>
  public InlineAsmKeyType(/*const*/ InlineAsm /*P*/ Asm, final SmallVectorImpl<Constant /*P*/ > /*&*/ $Prm1) {
    // : AsmString(Asm->getAsmString()), Constraints(Asm->getConstraintString()), FTy(Asm->getFunctionType()), HasSideEffects(Asm->hasSideEffects()), IsAlignStack(Asm->isAlignStack()), AsmDialect(Asm->getDialect()) 
    //START JInit
    this.AsmString = new StringRef(Asm.getAsmString());
    this.Constraints = new StringRef(Asm.getConstraintString());
    this.FTy = Asm.getFunctionType();
    this.HasSideEffects = Asm.hasSideEffects();
    this.IsAlignStack = Asm.isAlignStack();
    this.AsmDialect = Asm.getDialect();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsmKeyType::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 413,
   FQN="llvm::InlineAsmKeyType::operator==", NM="_ZNK4llvm16InlineAsmKeyTypeeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZNK4llvm16InlineAsmKeyTypeeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ InlineAsmKeyType /*&*/ X) /*const*/ {
    return HasSideEffects == X.HasSideEffects
       && IsAlignStack == X.IsAlignStack && AsmDialect == X.AsmDialect
       && $eq_StringRef(/*NO_COPY*/AsmString, /*NO_COPY*/X.AsmString) && $eq_StringRef(/*NO_COPY*/Constraints, /*NO_COPY*/X.Constraints)
       && FTy == X.FTy;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsmKeyType::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 419,
   FQN="llvm::InlineAsmKeyType::operator==", NM="_ZNK4llvm16InlineAsmKeyTypeeqEPKNS_9InlineAsmE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZNK4llvm16InlineAsmKeyTypeeqEPKNS_9InlineAsmE")
  //</editor-fold>
  public boolean $eq(/*const*/ InlineAsm /*P*/ Asm) /*const*/ {
    return HasSideEffects == Asm.hasSideEffects()
       && IsAlignStack == Asm.isAlignStack()
       && AsmDialect == Asm.getDialect()
       && $eq_StringRef(/*NO_COPY*/AsmString, new StringRef(Asm.getAsmString()))
       && $eq_StringRef(/*NO_COPY*/Constraints, new StringRef(Asm.getConstraintString()))
       && FTy == Asm.getFunctionType();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsmKeyType::getHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 427,
   FQN="llvm::InlineAsmKeyType::getHash", NM="_ZNK4llvm16InlineAsmKeyType7getHashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZNK4llvm16InlineAsmKeyType7getHashEv")
  //</editor-fold>
  public /*uint*/int getHash() /*const*/ {
    return hash_combine(AsmString, Constraints, HasSideEffects, IsAlignStack, 
        AsmDialect, FTy).$uint();
  }

  
  // JAVA: typedef ConstantInfo<InlineAsm>::TypeClass TypeClass
//  public final class TypeClass extends PointerType{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsmKeyType::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 433,
   FQN="llvm::InlineAsmKeyType::create", NM="_ZNK4llvm16InlineAsmKeyType6createEPNS_11PointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZNK4llvm16InlineAsmKeyType6createEPNS_11PointerTypeE")
  //</editor-fold>
  public InlineAsm /*P*/ create(PointerType /*P*/ Ty) /*const*/ {
    assert (PointerType.getUnqual(FTy) == Ty);
    return new InlineAsm(FTy, AsmString.$string(), Constraints.$string(), HasSideEffects, 
        IsAlignStack, AsmDialect);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsmKeyType::InlineAsmKeyType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 394,
   FQN="llvm::InlineAsmKeyType::InlineAsmKeyType", NM="_ZN4llvm16InlineAsmKeyTypeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm16InlineAsmKeyTypeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ InlineAsmKeyType(final /*const*/ InlineAsmKeyType /*&*/ $Prm0) {
    // : AsmString(.AsmString), Constraints(.Constraints), FTy(.FTy), HasSideEffects(.HasSideEffects), IsAlignStack(.IsAlignStack), AsmDialect(.AsmDialect) 
    //START JInit
    this.AsmString = new StringRef($Prm0.AsmString);
    this.Constraints = new StringRef($Prm0.Constraints);
    this.FTy = $Prm0.FTy;
    this.HasSideEffects = $Prm0.HasSideEffects;
    this.IsAlignStack = $Prm0.IsAlignStack;
    this.AsmDialect = $Prm0.AsmDialect;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::InlineAsmKeyType::InlineAsmKeyType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 394,
   FQN="llvm::InlineAsmKeyType::InlineAsmKeyType", NM="_ZN4llvm16InlineAsmKeyTypeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/InlineAsm.cpp -nm=_ZN4llvm16InlineAsmKeyTypeC1EOS0_")
  //</editor-fold>
  public /*inline*/ InlineAsmKeyType(JD$Move _dparam, final InlineAsmKeyType /*&&*/$Prm0) {
    // : AsmString(static_cast<InlineAsmKeyType &&>().AsmString), Constraints(static_cast<InlineAsmKeyType &&>().Constraints), FTy(static_cast<InlineAsmKeyType &&>().FTy), HasSideEffects(static_cast<InlineAsmKeyType &&>().HasSideEffects), IsAlignStack(static_cast<InlineAsmKeyType &&>().IsAlignStack), AsmDialect(static_cast<InlineAsmKeyType &&>().AsmDialect) 
    //START JInit
    this.AsmString = new StringRef(JD$Move.INSTANCE, $Prm0.AsmString);
    this.Constraints = new StringRef(JD$Move.INSTANCE, $Prm0.Constraints);
    this.FTy = $Prm0.FTy;
    this.HasSideEffects = $Prm0.HasSideEffects;
    this.IsAlignStack = $Prm0.IsAlignStack;
    this.AsmDialect = $Prm0.AsmDialect;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "AsmString=" + AsmString // NOI18N
              + ", Constraints=" + Constraints // NOI18N
              + ", FTy=" + FTy // NOI18N
              + ", HasSideEffects=" + HasSideEffects // NOI18N
              + ", IsAlignStack=" + IsAlignStack // NOI18N
              + ", AsmDialect=" + AsmDialect; // NOI18N
  }
}
