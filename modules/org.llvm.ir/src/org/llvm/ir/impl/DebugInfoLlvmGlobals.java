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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.mdconst.MdconstGlobals;
import org.llvm.pass.*;


//<editor-fold defaultstate="collapsed" desc="static type DebugInfoLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.DebugInfoLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm14StripDebugInfoERNS_6ModuleE;_ZN4llvm14stripDebugInfoERNS_8FunctionE;_ZN4llvm15getDISubprogramEPKNS_6MDNodeE;_ZN4llvm33getDebugMetadataVersionFromModuleERKNS_6ModuleE; -static-type=DebugInfoLlvmGlobals -package=org.llvm.ir.impl")
//</editor-fold>
public final class DebugInfoLlvmGlobals {


/// \brief Find subprogram that is enclosing this scope.
//<editor-fold defaultstate="collapsed" desc="llvm::getDISubprogram">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 34,
 FQN="llvm::getDISubprogram", NM="_ZN4llvm15getDISubprogramEPKNS_6MDNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm15getDISubprogramEPKNS_6MDNodeE")
//</editor-fold>
public static DISubprogram /*P*/ getDISubprogram(/*const*/ MDNode /*P*/ Scope) {
  {
    /*const*/ DILocalScope /*P*/ LocalScope = dyn_cast_or_null_DILocalScope(Scope);
    if ((LocalScope != null)) {
      return LocalScope.getSubprogram();
    }
  }
  return null;
}


/// \brief Strip debug info in the module if it exists.
///
/// To do this, we remove all calls to the debugger intrinsics and any named
/// metadata for debugging. We also remove debug locations for instructions.
/// Return true if module is modified.
//<editor-fold defaultstate="collapsed" desc="llvm::StripDebugInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 268,
 FQN="llvm::StripDebugInfo", NM="_ZN4llvm14StripDebugInfoERNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm14StripDebugInfoERNS_6ModuleE")
//</editor-fold>
public static boolean StripDebugInfo(final Module /*&*/ M) {
  boolean Changed = false;
  
  for (ilist_iterator<NamedMDNode> NMI = M.named_metadata_begin(), 
      NME = M.named_metadata_end(); NMI.$noteq(NME);) {
    NamedMDNode /*P*/ NMD = $AddrOf(NMI.$star());
    NMI.$preInc();
    if (NMD.getName().startswith(/*STRINGREF_STR*/"llvm.dbg.")) {
      NMD.eraseFromParent();
      Changed = true;
    }
  }
  
  for (final Function /*&*/ F : M)  {
    Changed |= IrLlvmGlobals.stripDebugInfo(F);
  }
  {
    
    GVMaterializer /*P*/ Materializer = M.getMaterializer();
    if ((Materializer != null)) {
      Materializer.setStripDebugInfo();
    }
  }
  
  return Changed;
}

//<editor-fold defaultstate="collapsed" desc="llvm::stripDebugInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 244,
 FQN="llvm::stripDebugInfo", NM="_ZN4llvm14stripDebugInfoERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm14stripDebugInfoERNS_8FunctionE")
//</editor-fold>
public static boolean stripDebugInfo(final Function /*&*/ F) {
  boolean Changed = false;
  if ((F.getSubprogram() != null)) {
    Changed = true;
    F.setSubprogram((DISubprogram /*P*/ )null);
  }
  
  for (final BasicBlock /*&*/ BB : F) {
    for (ilist_iterator<Instruction> II = BB.begin(), End = BB.end(); II.$noteq(End);) {
      final Instruction /*&*/ I = II.$postInc(0).$star(); // We may delete the instruction, increment now.
      if (isa_DbgInfoIntrinsic($AddrOf(I))) {
        I.eraseFromParent();
        Changed = true;
        continue;
      }
      if (I.getDebugLoc().$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          Changed = true;
          I.setDebugLoc($c$.track(new DebugLoc())); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  return Changed;
}


/// \brief Return Debug Info Metadata Version by checking module flags.
//<editor-fold defaultstate="collapsed" desc="llvm::getDebugMetadataVersionFromModule">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp", line = 290,
 FQN="llvm::getDebugMetadataVersionFromModule", NM="_ZN4llvm33getDebugMetadataVersionFromModuleERKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/DebugInfo.cpp -nm=_ZN4llvm33getDebugMetadataVersionFromModuleERKNS_6ModuleE")
//</editor-fold>
public static /*uint*/int getDebugMetadataVersionFromModule(final /*const*/ Module /*&*/ M) {
  {
    ConstantInt /*P*/ Val = MdconstGlobals.dyn_extract_or_null$ValidReference(ConstantInt.class, M.getModuleFlag(new StringRef(/*KEEP_STR*/"Debug Info Version")));
    if ((Val != null)) {
      return $ulong2uint(Val.getZExtValue());
    }
  }
  return 0;
}

} // END OF class DebugInfoLlvmGlobals
