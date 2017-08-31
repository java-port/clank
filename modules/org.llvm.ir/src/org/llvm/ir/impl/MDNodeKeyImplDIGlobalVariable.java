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

import org.clank.support.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.ir.java.MDNodeKeyImpl;

//<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIGlobalVariable>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 752,
 FQN="llvm::MDNodeKeyImpl<DIGlobalVariable>", NM="_ZN4llvm13MDNodeKeyImplINS_16DIGlobalVariableEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_16DIGlobalVariableEEE")
//</editor-fold>
public class/*struct*/ MDNodeKeyImplDIGlobalVariable implements MDNodeKeyImpl<DIGlobalVariable> {
  public Metadata /*P*/ Scope;
  public MDString /*P*/ Name;
  public MDString /*P*/ LinkageName;
  public Metadata /*P*/ File;
  public /*uint*/int Line;
  public Metadata /*P*/ Type;
  public boolean IsLocalToUnit;
  public boolean IsDefinition;
  public Metadata /*P*/ Variable;
  public Metadata /*P*/ StaticDataMemberDeclaration;

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIGlobalVariable>::MDNodeKeyImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 764,
   FQN="llvm::MDNodeKeyImpl<DIGlobalVariable>::MDNodeKeyImpl", NM="_ZN4llvm13MDNodeKeyImplINS_16DIGlobalVariableEEC1EPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbS4_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_16DIGlobalVariableEEC1EPNS_8MetadataEPNS_8MDStringES6_S4_jS4_bbS4_S4_")
  //</editor-fold>
  public MDNodeKeyImplDIGlobalVariable(Metadata /*P*/ Scope, MDString /*P*/ Name, MDString /*P*/ LinkageName,
      Metadata /*P*/ File, /*uint*/int Line, Metadata /*P*/ Type,
      boolean IsLocalToUnit, boolean IsDefinition, Metadata /*P*/ Variable,
      Metadata /*P*/ StaticDataMemberDeclaration) {
    // : Scope(Scope), Name(Name), LinkageName(LinkageName), File(File), Line(Line), Type(Type), IsLocalToUnit(IsLocalToUnit), IsDefinition(IsDefinition), Variable(Variable), StaticDataMemberDeclaration(StaticDataMemberDeclaration)
    //START JInit
    this.Scope = Scope;
    this.Name = Name;
    this.LinkageName = LinkageName;
    this.File = File;
    this.Line = Line;
    this.Type = Type;
    this.IsLocalToUnit = IsLocalToUnit;
    this.IsDefinition = IsDefinition;
    this.Variable = Variable;
    this.StaticDataMemberDeclaration = StaticDataMemberDeclaration;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIGlobalVariable>::MDNodeKeyImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 772,
   FQN="llvm::MDNodeKeyImpl<DIGlobalVariable>::MDNodeKeyImpl", NM="_ZN4llvm13MDNodeKeyImplINS_16DIGlobalVariableEEC1EPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvm13MDNodeKeyImplINS_16DIGlobalVariableEEC1EPKS1_")
  //</editor-fold>
  public MDNodeKeyImplDIGlobalVariable(/*const*/ DIGlobalVariable /*P*/ N) {
    // : Scope(N->getRawScope()), Name(N->getRawName()), LinkageName(N->getRawLinkageName()), File(N->getRawFile()), Line(N->getLine()), Type(N->getRawType()), IsLocalToUnit(N->isLocalToUnit()), IsDefinition(N->isDefinition()), Variable(N->getRawVariable()), StaticDataMemberDeclaration(N->getRawStaticDataMemberDeclaration())
    //START JInit
    this.Scope = N.getRawScope();
    this.Name = N.getRawName();
    this.LinkageName = N.getRawLinkageName();
    this.File = N.getRawFile();
    this.Line = N.getLine();
    this.Type = N.getRawType();
    this.IsLocalToUnit = N.isLocalToUnit();
    this.IsDefinition = N.isDefinition();
    this.Variable = N.getRawVariable();
    this.StaticDataMemberDeclaration = N.getRawStaticDataMemberDeclaration();
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIGlobalVariable>::isKeyOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 780,
   FQN="llvm::MDNodeKeyImpl<DIGlobalVariable>::isKeyOf", NM="_ZNK4llvm13MDNodeKeyImplINS_16DIGlobalVariableEE7isKeyOfEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm13MDNodeKeyImplINS_16DIGlobalVariableEE7isKeyOfEPKS1_")
  //</editor-fold>
  public boolean isKeyOf(/*const*/ DIGlobalVariable /*P*/ RHS) /*const*/ {
    return Scope == RHS.getRawScope() && Name == RHS.getRawName()
       && LinkageName == RHS.getRawLinkageName()
       && File == RHS.getRawFile() && Line == RHS.getLine()
       && Type == RHS.getRawType() && IsLocalToUnit == RHS.isLocalToUnit()
       && IsDefinition == RHS.isDefinition()
       && Variable == RHS.getRawVariable()
       && StaticDataMemberDeclaration
       == RHS.getRawStaticDataMemberDeclaration();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MDNodeKeyImpl<DIGlobalVariable>::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.h", line = 790,
   FQN="llvm::MDNodeKeyImpl<DIGlobalVariable>::getHashValue", NM="_ZNK4llvm13MDNodeKeyImplINS_16DIGlobalVariableEE12getHashValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZNK4llvm13MDNodeKeyImplINS_16DIGlobalVariableEE12getHashValueEv")
  //</editor-fold>
  public /*uint*/int getHashValue() /*const*/ {
    return HashingGlobals.hash_combine_ptr(Scope, 
      HashingGlobals.hash_combine_ptr(Name, 
        HashingGlobals.hash_combine_ptr(LinkageName, 
          HashingGlobals.hash_combine_ptr(File, 
            HashingGlobals.hash_combine_ptr(Type, 
              HashingGlobals.hash_combine_ptr(Variable, 
                HashingGlobals.hash_combine_ptr(StaticDataMemberDeclaration, 
                        HashingGlobals.hash_combine(HashingGlobals.hash_value(Line),IsLocalToUnit, IsDefinition),
                        true),
                      true),
                    true),
                  true),
                true),
              true),
            true).$uint();
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
              + ", Variable=" + Variable // NOI18N
              + ", StaticDataMemberDeclaration=" + StaticDataMemberDeclaration; // NOI18N
  }
}
