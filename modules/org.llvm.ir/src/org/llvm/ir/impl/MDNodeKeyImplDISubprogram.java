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

//<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DISubprogram>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 518,
 FQN="llvm::MDNodeKeyImpl<DISubprogram>", NM="_ZN4llvm13MDNodeKeyImplINS_12DISubprogramEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_12DISubprogramEEE")
//</editor-fold>
public class/*struct*/ MDNodeKeyImplDISubprogram implements MDNodeKeyImpl<DISubprogram> {
  public Metadata /*P*/ Scope;
  public MDString /*P*/ Name;
  public MDString /*P*/ LinkageName;
  public Metadata /*P*/ File;
  public /*uint*/int Line;
  public Metadata /*P*/ Type;
  public boolean IsLocalToUnit;
  public boolean IsDefinition;
  public /*uint*/int ScopeLine;
  public Metadata /*P*/ ContainingType;
  public /*uint*/int Virtuality;
  public /*uint*/int VirtualIndex;
  public int ThisAdjustment;
  public /*uint*/int Flags;
  public boolean IsOptimized;
  public Metadata /*P*/ Unit;
  public Metadata /*P*/ TemplateParams;
  public Metadata /*P*/ Declaration;
  public Metadata /*P*/ Variables;

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DISubprogram>::MDNodeKeyImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 539,
   FQN="llvm::MDNodeKeyImpl<DISubprogram>::MDNodeKeyImpl", NM="_ZN4llvm13MDNodeKeyImplINS_12DISubprogramEEC1EPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbjS4_jjijbS4_S4_S4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_12DISubprogramEEC1EPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbjS4_jjijbS4_S4_S4_S4_")
  //</editor-fold>
  public MDNodeKeyImplDISubprogram(Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName,
      Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type,
      boolean IsLocalToUnit, boolean IsDefinition, /*uint*/int ScopeLine,
      Metadata /*P*/ ContainingType, /*uint*/int Virtuality,
      /*uint*/int VirtualIndex, int ThisAdjustment, /*uint*/int Flags,
      boolean IsOptimized, Metadata /*P*/ Unit, Metadata /*P*/ TemplateParams,
      Metadata /*P*/ Declaration, Metadata /*P*/ Variables) {
    // : Scope(Scope), Name(Name), LinkageName(LinkageName), File(File), Line(Line), Type(Type), IsLocalToUnit(IsLocalToUnit), IsDefinition(IsDefinition), ScopeLine(ScopeLine), ContainingType(ContainingType), Virtuality(Virtuality), VirtualIndex(VirtualIndex), ThisAdjustment(ThisAdjustment), Flags(Flags), IsOptimized(IsOptimized), Unit(Unit), TemplateParams(TemplateParams), Declaration(Declaration), Variables(Variables)
    //START JInit
    this.Scope = Scope;
    this.Name = Name;
    this.LinkageName = LinkageName;
    this.File = File;
    this.Line = Line;
    this.Type = Type;
    this.IsLocalToUnit = IsLocalToUnit;
    this.IsDefinition = IsDefinition;
    this.ScopeLine = ScopeLine;
    this.ContainingType = ContainingType;
    this.Virtuality = Virtuality;
    this.VirtualIndex = VirtualIndex;
    this.ThisAdjustment = ThisAdjustment;
    this.Flags = Flags;
    this.IsOptimized = IsOptimized;
    this.Unit = Unit;
    this.TemplateParams = TemplateParams;
    this.Declaration = Declaration;
    this.Variables = Variables;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DISubprogram>::MDNodeKeyImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 554,
   FQN="llvm::MDNodeKeyImpl<DISubprogram>::MDNodeKeyImpl", NM="_ZN4llvm13MDNodeKeyImplINS_12DISubprogramEEC1EPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_12DISubprogramEEC1EPKS1_")
  //</editor-fold>
  public MDNodeKeyImplDISubprogram(/*const*/ DISubprogram /*P*/ N) {
    // : Scope(N->getRawScope()), Name(N->getRawName()), LinkageName(N->getRawLinkageName()), File(N->getRawFile()), Line(N->getLine()), Type(N->getRawType()), IsLocalToUnit(N->isLocalToUnit()), IsDefinition(N->isDefinition()), ScopeLine(N->getScopeLine()), ContainingType(N->getRawContainingType()), Virtuality(N->getVirtuality()), VirtualIndex(N->getVirtualIndex()), ThisAdjustment(N->getThisAdjustment()), Flags(N->getFlags()), IsOptimized(N->isOptimized()), Unit(N->getRawUnit()), TemplateParams(N->getRawTemplateParams()), Declaration(N->getRawDeclaration()), Variables(N->getRawVariables())
    //START JInit
    this.Scope = N.getRawScope();
    this.Name = N.getRawName();
    this.LinkageName = N.getRawLinkageName();
    this.File = N.getRawFile();
    this.Line = N.getLine();
    this.Type = N.getRawType();
    this.IsLocalToUnit = N.isLocalToUnit();
    this.IsDefinition = N.isDefinition();
    this.ScopeLine = N.getScopeLine();
    this.ContainingType = N.getRawContainingType();
    this.Virtuality = N.getVirtuality();
    this.VirtualIndex = N.getVirtualIndex();
    this.ThisAdjustment = N.getThisAdjustment();
    this.Flags = N.getFlags();
    this.IsOptimized = N.isOptimized();
    this.Unit = N.getRawUnit();
    this.TemplateParams = N.getRawTemplateParams();
    this.Declaration = N.getRawDeclaration();
    this.Variables = N.getRawVariables();
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DISubprogram>::isKeyOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 566,
   FQN="llvm::MDNodeKeyImpl<DISubprogram>::isKeyOf", NM="_ZNK4llvm13MDNodeKeyImplINS_12DISubprogramEE7isKeyOfEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm13MDNodeKeyImplINS_12DISubprogramEE7isKeyOfEPKS1_")
  //</editor-fold>
  public boolean isKeyOf(/*const*/ DISubprogram /*P*/ RHS) /*const*/ {
    return Scope == RHS.getRawScope() && Name == RHS.getRawName()
       && LinkageName == RHS.getRawLinkageName()
       && File == RHS.getRawFile() && Line == RHS.getLine()
       && Type == RHS.getRawType() && IsLocalToUnit == RHS.isLocalToUnit()
       && IsDefinition == RHS.isDefinition()
       && ScopeLine == RHS.getScopeLine()
       && ContainingType == RHS.getRawContainingType()
       && Virtuality == RHS.getVirtuality()
       && VirtualIndex == RHS.getVirtualIndex()
       && ThisAdjustment == RHS.getThisAdjustment()
       && Flags == RHS.getFlags() && IsOptimized == RHS.isOptimized()
       && Unit == RHS.getUnit()
       && TemplateParams == RHS.getRawTemplateParams()
       && Declaration == RHS.getRawDeclaration()
       && Variables == RHS.getRawVariables();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DISubprogram>::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 583,
   FQN="llvm::MDNodeKeyImpl<DISubprogram>::getHashValue", NM="_ZNK4llvm13MDNodeKeyImplINS_12DISubprogramEE12getHashValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm13MDNodeKeyImplINS_12DISubprogramEE12getHashValueEv")
  //</editor-fold>
  public /*uint*/int getHashValue() /*const*/ {
    // If this is a declaration inside an ODR type, only hash the type and the
    // name.  Otherwise the hash will be stronger than
    // MDNodeSubsetEqualImpl::isDeclarationOfODRMember().
    if (!IsDefinition && (LinkageName != null)) {
      {
        DICompositeType /*P*/ CT = dyn_cast_or_null_DICompositeType(Scope);
        if ((CT != null)) {
          if ((CT.getRawIdentifier() != null)) {
            return hash_combine(hash_value_ptr(LinkageName), hash_value_ptr(Scope)).$uint();
          }
        }
      }
    }

    // Intentionally computes the hash on a subset of the operands for
    // performance reason. The subset has to be significant enough to avoid
    // collision "most of the time". There is no correctness issue in case of
    // collision because of the full check above.
    return hash_combine(hash_value_ptr(Name), hash_value_ptr(Scope), hash_value_ptr(File), hash_value_ptr(Type), Line).$uint();
  }


  @Override public String toString() {
    return "" + "Scope=" + Scope // NOI18N
              + ", Name=" + Name // NOI18N
              + ", LinkageName=" + LinkageName // NOI18N
              + ", File=" + File // NOI18N
              + ", Line=" + Line // NOI18N
              + ", Type=" + Type // NOI18N
              + ", IsLocalToUnit=" + IsLocalToUnit // NOI18N
              + ", IsDefinition=" + IsDefinition // NOI18N
              + ", ScopeLine=" + ScopeLine // NOI18N
              + ", ContainingType=" + ContainingType // NOI18N
              + ", Virtuality=" + Virtuality // NOI18N
              + ", VirtualIndex=" + VirtualIndex // NOI18N
              + ", ThisAdjustment=" + ThisAdjustment // NOI18N
              + ", Flags=" + Flags // NOI18N
              + ", IsOptimized=" + IsOptimized // NOI18N
              + ", Unit=" + Unit // NOI18N
              + ", TemplateParams=" + TemplateParams // NOI18N
              + ", Declaration=" + Declaration // NOI18N
              + ", Variables=" + Variables; // NOI18N
  }
}
