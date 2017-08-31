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

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SanitizerMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.h", line = 33,
 FQN="clang::CodeGen::SanitizerMetadata", NM="_ZN5clang7CodeGen17SanitizerMetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp -nm=_ZN5clang7CodeGen17SanitizerMetadataE")
//</editor-fold>
public class SanitizerMetadata {
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SanitizerMetadata::SanitizerMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.h", line = 34,
   FQN="clang::CodeGen::SanitizerMetadata::SanitizerMetadata", NM="_ZN5clang7CodeGen17SanitizerMetadataC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp -nm=_ZN5clang7CodeGen17SanitizerMetadataC1ERKS1_")
  //</editor-fold>
  protected/*private*/ SanitizerMetadata(final /*const*/ SanitizerMetadata /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SanitizerMetadata::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.h", line = 35,
   FQN="clang::CodeGen::SanitizerMetadata::operator=", NM="_ZN5clang7CodeGen17SanitizerMetadataaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp -nm=_ZN5clang7CodeGen17SanitizerMetadataaSERKS1_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ SanitizerMetadata /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  private final CodeGenModule /*&*/ CGM;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SanitizerMetadata::SanitizerMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp", line = 22,
   FQN="clang::CodeGen::SanitizerMetadata::SanitizerMetadata", NM="_ZN5clang7CodeGen17SanitizerMetadataC1ERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp -nm=_ZN5clang7CodeGen17SanitizerMetadataC1ERNS0_13CodeGenModuleE")
  //</editor-fold>
  public SanitizerMetadata(final CodeGenModule /*&*/ CGM) {
    // : CGM(CGM) 
    //START JInit
    this./*&*/CGM=/*&*/CGM;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SanitizerMetadata::reportGlobalToASan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp", line = 58,
   FQN="clang::CodeGen::SanitizerMetadata::reportGlobalToASan", NM="_ZN5clang7CodeGen17SanitizerMetadata18reportGlobalToASanEPN4llvm14GlobalVariableERKNS_7VarDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp -nm=_ZN5clang7CodeGen17SanitizerMetadata18reportGlobalToASanEPN4llvm14GlobalVariableERKNS_7VarDeclEb")
  //</editor-fold>
  public void reportGlobalToASan(GlobalVariable /*P*/ GV, 
                    final /*const*/ VarDecl /*&*/ D) {
    reportGlobalToASan(GV, 
                    D, false);
  }
  public void reportGlobalToASan(GlobalVariable /*P*/ GV, 
                    final /*const*/ VarDecl /*&*/ D, boolean IsDynInit/*= false*/) {
    raw_string_ostream OS = null;
    try {
      if (!CGM.getLangOpts().Sanitize.hasOneOf(SanitizerKind.Address
             | SanitizerKind.KernelAddress)) {
        return;
      }
      std.string QualName/*J*/= new std.string();
      OS/*J*/= new raw_string_ostream(QualName);
      D.printQualifiedName(OS);
      reportGlobalToASan(GV, D.getLocation(), new StringRef(OS.str()), D.getType(), IsDynInit);
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SanitizerMetadata::reportGlobalToASan">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp", line = 24,
   FQN="clang::CodeGen::SanitizerMetadata::reportGlobalToASan", NM="_ZN5clang7CodeGen17SanitizerMetadata18reportGlobalToASanEPN4llvm14GlobalVariableENS_14SourceLocationENS2_9StringRefENS_8QualTypeEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp -nm=_ZN5clang7CodeGen17SanitizerMetadata18reportGlobalToASanEPN4llvm14GlobalVariableENS_14SourceLocationENS2_9StringRefENS_8QualTypeEbb")
  //</editor-fold>
  public void reportGlobalToASan(GlobalVariable /*P*/ GV, 
                    SourceLocation Loc, StringRef Name, 
                    QualType Ty) {
    reportGlobalToASan(GV, 
                    Loc, Name, 
                    Ty, false, 
                    false);
  }
  public void reportGlobalToASan(GlobalVariable /*P*/ GV, 
                    SourceLocation Loc, StringRef Name, 
                    QualType Ty, boolean IsDynInit/*= false*/) {
    reportGlobalToASan(GV, 
                    Loc, Name, 
                    Ty, IsDynInit, 
                    false);
  }
  public void reportGlobalToASan(GlobalVariable /*P*/ GV, 
                    SourceLocation Loc, StringRef Name, 
                    QualType Ty, boolean IsDynInit/*= false*/, 
                    boolean IsBlacklisted/*= false*/) {
    if (!CGM.getLangOpts().Sanitize.hasOneOf(SanitizerKind.Address
           | SanitizerKind.KernelAddress)) {
      return;
    }
    IsDynInit &= !CGM.isInSanitizerBlacklist(GV, new SourceLocation(Loc), new QualType(Ty), new StringRef(/*KEEP_STR*/"init"));
    IsBlacklisted |= CGM.isInSanitizerBlacklist(GV, new SourceLocation(Loc), new QualType(Ty));
    
    Metadata /*P*/ LocDescr = null;
    Metadata /*P*/ GlobalName = null;
    final LLVMContext /*&*/ VMContext = CGM.getLLVMContext();
    if (!IsBlacklisted) {
      // Don't generate source location and global name if it is blacklisted -
      // it won't be instrumented anyway.
      LocDescr = getLocationMetadata(new SourceLocation(Loc));
      if (!Name.empty()) {
        GlobalName = MDString.get(VMContext, new StringRef(Name));
      }
    }
    
    Metadata /*P*/ GlobalMetadata[/*5*/] = new Metadata /*P*/  [/*5*/] {
      ConstantAsMetadata.get(GV), LocDescr, GlobalName, 
      ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt1Ty(VMContext), (IsDynInit ? 1 : 0))), 
      ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt1Ty(VMContext), (IsBlacklisted ? 1 : 0)))
    };
    
    MDNode /*P*/ ThisGlobal = MDNode.get(VMContext, new ArrayRef<Metadata /*P*/ >(GlobalMetadata, true));
    NamedMDNode /*P*/ AsanGlobals = CGM.getModule().getOrInsertNamedMetadata(new StringRef(/*KEEP_STR*/"llvm.asan.globals"));
    AsanGlobals.addOperand(ThisGlobal);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SanitizerMetadata::disableSanitizerForGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp", line = 69,
   FQN="clang::CodeGen::SanitizerMetadata::disableSanitizerForGlobal", NM="_ZN5clang7CodeGen17SanitizerMetadata25disableSanitizerForGlobalEPN4llvm14GlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp -nm=_ZN5clang7CodeGen17SanitizerMetadata25disableSanitizerForGlobalEPN4llvm14GlobalVariableE")
  //</editor-fold>
  public void disableSanitizerForGlobal(GlobalVariable /*P*/ GV) {
    // For now, just make sure the global is not modified by the ASan
    // instrumentation.
    if (CGM.getLangOpts().Sanitize.hasOneOf(SanitizerKind.Address
           | SanitizerKind.KernelAddress)) {
      reportGlobalToASan(GV, new SourceLocation(), new StringRef(/*KEEP_STR*/$EMPTY), new QualType(), false, true);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SanitizerMetadata::disableSanitizerForInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp", line = 77,
   FQN="clang::CodeGen::SanitizerMetadata::disableSanitizerForInstruction", NM="_ZN5clang7CodeGen17SanitizerMetadata30disableSanitizerForInstructionEPN4llvm11InstructionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp -nm=_ZN5clang7CodeGen17SanitizerMetadata30disableSanitizerForInstructionEPN4llvm11InstructionE")
  //</editor-fold>
  public void disableSanitizerForInstruction(Instruction /*P*/ I) {
    I.setMetadata(CGM.getModule().getMDKindID(new StringRef(/*KEEP_STR*/"nosanitize")), 
        MDNode.get(CGM.getLLVMContext(), new ArrayRef<Metadata /*P*/ >(None, true)));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::SanitizerMetadata::getLocationMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp", line = 82,
   FQN="clang::CodeGen::SanitizerMetadata::getLocationMetadata", NM="_ZN5clang7CodeGen17SanitizerMetadata19getLocationMetadataENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/SanitizerMetadata.cpp -nm=_ZN5clang7CodeGen17SanitizerMetadata19getLocationMetadataENS_14SourceLocationE")
  //</editor-fold>
  private MDNode /*P*/ getLocationMetadata(SourceLocation Loc) {
    PresumedLoc PLoc = CGM.getContext().getSourceManager().getPresumedLoc(/*NO_COPY*/Loc);
    if (!PLoc.isValid()) {
      return null;
    }
    final LLVMContext /*&*/ VMContext = CGM.getLLVMContext();
    Metadata /*P*/ LocMetadata[/*3*/] = new Metadata /*P*/  [/*3*/] {
      MDString.get(VMContext, PLoc.getFilename()), 
      ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt32Ty(VMContext), $uint2ulong(PLoc.getLine()))), 
      ConstantAsMetadata.get(ConstantInt.get(org.llvm.ir.Type.getInt32Ty(VMContext), $uint2ulong(PLoc.getColumn())))
    };
    return MDNode.get(VMContext, new ArrayRef<Metadata /*P*/ >(LocMetadata, true));
  }

  
  @Override public String toString() {
    return "" + "CGM=" + CGM; // NOI18N
  }
}
