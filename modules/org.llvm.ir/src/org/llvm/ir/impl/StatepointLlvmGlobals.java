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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import org.llvm.ir.intrinsic.ID;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.pass.*;


//<editor-fold defaultstate="collapsed" desc="static type StatepointLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.StatepointLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm10isGCResultENS_17ImmutableCallSiteE;_ZN4llvm12isGCRelocateENS_17ImmutableCallSiteE;_ZN4llvm12isStatepointENS_17ImmutableCallSiteE;_ZN4llvm12isStatepointEPKNS_5ValueE;_ZN4llvm12isStatepointERKNS_5ValueE;_ZN4llvm25isStatepointDirectiveAttrENS_9AttributeE;_ZN4llvm34parseStatepointDirectivesFromAttrsENS_12AttributeSetE; -static-type=StatepointLlvmGlobals -package=org.llvm.ir.impl")
//</editor-fold>
public final class StatepointLlvmGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::isStatepoint">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp", line = 27,
 FQN="llvm::isStatepoint", NM="_ZN4llvm12isStatepointENS_17ImmutableCallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm12isStatepointENS_17ImmutableCallSiteE")
//</editor-fold>
public static boolean isStatepoint(ImmutableCallSite CS) {
  {
    /*const*/ Function /*P*/ F = StatepointStatics.getCalledFunction(new ImmutableCallSite(CS));
    if ((F != null)) {
      return F.getIntrinsicID() == ID.experimental_gc_statepoint;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="llvm::isStatepoint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp", line = 33,
 FQN="llvm::isStatepoint", NM="_ZN4llvm12isStatepointEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm12isStatepointEPKNS_5ValueE")
//</editor-fold>
public static boolean isStatepoint_Value$C$P(/*const*/ Value /*P*/ V) {
  {
    ImmutableCallSite CS = new ImmutableCallSite(V);
    if (CS.$bool()) {
      return IrLlvmGlobals.isStatepoint(new ImmutableCallSite(CS));
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="llvm::isStatepoint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp", line = 39,
 FQN="llvm::isStatepoint", NM="_ZN4llvm12isStatepointERKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm12isStatepointERKNS_5ValueE")
//</editor-fold>
public static boolean isStatepoint_Value$C(final /*const*/ Value /*&*/ V) {
  return IrLlvmGlobals.isStatepoint_Value$C$P($AddrOf(V));
}

//<editor-fold defaultstate="collapsed" desc="llvm::isGCRelocate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp", line = 43,
 FQN="llvm::isGCRelocate", NM="_ZN4llvm12isGCRelocateENS_17ImmutableCallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm12isGCRelocateENS_17ImmutableCallSiteE")
//</editor-fold>
public static boolean isGCRelocate(ImmutableCallSite CS) {
  return (CS.getInstruction() != null) && isa_GCRelocateInst(CS.getInstruction());
}

//<editor-fold defaultstate="collapsed" desc="llvm::isGCResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp", line = 47,
 FQN="llvm::isGCResult", NM="_ZN4llvm10isGCResultENS_17ImmutableCallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm10isGCResultENS_17ImmutableCallSiteE")
//</editor-fold>
public static boolean isGCResult(ImmutableCallSite CS) {
  return (CS.getInstruction() != null) && isa_GCResultInst(CS.getInstruction());
}


/// Parse out statepoint directives from the function attributes present in \p
/// AS.
//<editor-fold defaultstate="collapsed" desc="llvm::parseStatepointDirectivesFromAttrs">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp", line = 56,
 FQN="llvm::parseStatepointDirectivesFromAttrs", NM="_ZN4llvm34parseStatepointDirectivesFromAttrsENS_12AttributeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm34parseStatepointDirectivesFromAttrsENS_12AttributeSetE")
//</editor-fold>
public static StatepointDirectives parseStatepointDirectivesFromAttrs(AttributeSet AS) {
  StatepointDirectives Result = null;
  try {
    Result/*J*/= new StatepointDirectives();
    
    Attribute AttrID = AS.getAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), new StringRef(/*KEEP_STR*/"statepoint-id"));
    ulong$ref StatepointID = create_ulong$ref();
    if (AttrID.isStringAttribute()) {
      if (!AttrID.getValueAsString().getAsInteger$NotSigned(10, StatepointID)) {
        Result.StatepointID.$assign/*_T$C$R*/(StatepointID.$deref());
      }
    }
    
    uint$ref NumPatchBytes = create_uint$ref();
    Attribute AttrNumPatchBytes = AS.getAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
        new StringRef(/*KEEP_STR*/"statepoint-num-patch-bytes"));
    if (AttrNumPatchBytes.isStringAttribute()) {
      if (!AttrNumPatchBytes.getValueAsString().getAsInteger$NotSigned(10, NumPatchBytes)) {
        Result.NumPatchBytes.$assign_T$C$R(NumPatchBytes.$deref());
      }
    }
    
    return new StatepointDirectives(JD$Move.INSTANCE, Result);
  } finally {
    if (Result != null) { Result.$destroy(); }
  }
}


/// Return \c true if the the \p Attr is an attribute that is a statepoint
/// directive.
//<editor-fold defaultstate="collapsed" desc="llvm::isStatepointDirectiveAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp", line = 51,
 FQN="llvm::isStatepointDirectiveAttr", NM="_ZN4llvm25isStatepointDirectiveAttrENS_9AttributeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Statepoint.cpp -nm=_ZN4llvm25isStatepointDirectiveAttrENS_9AttributeE")
//</editor-fold>
public static boolean isStatepointDirectiveAttr(Attribute Attr) {
  return Attr.hasAttribute(new StringRef(/*KEEP_STR*/"statepoint-id"))
     || Attr.hasAttribute(new StringRef(/*KEEP_STR*/"statepoint-num-patch-bytes"));
}

} // END OF class StatepointLlvmGlobals
