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
package org.llvm.transforms.ipo.impl;

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
import org.llvm.adt.StringRef;
import org.llvm.cl.ClGlobals;
import org.llvm.cl.OptionHidden;
import org.llvm.cl.desc;
import org.llvm.cl.listStringBool;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.ir.legacy.*;
import org.llvm.transforms.*;
import org.llvm.transforms.java.TransformFunctionPointers.*;
import org.llvm.transforms.ipo.*;
import org.llvm.transforms.utils.*;
import org.llvm.support.yaml.*;
import org.llvm.pass.*;
import org.llvm.target.target.*;
import org.llvm.transforms.java.TransformDummies.*;


//<editor-fold defaultstate="collapsed" desc="static type ForceFunctionAttrsStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.transforms.ipo.impl.ForceFunctionAttrsStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp -nm=_ZL13parseAttrKindN4llvm9StringRefE;_ZL15ForceAttributesB5cxx11;_ZL19addForcedAttributesRN4llvm8FunctionE;_ZL46InitializeForceFunctionAttrsLegacyPassPassFlag;_ZL46initializeForceFunctionAttrsLegacyPassPassOnceRN4llvm12PassRegistryE; -static-type=ForceFunctionAttrsStatics -package=org.llvm.transforms.ipo.impl")
//</editor-fold>
public final class ForceFunctionAttrsStatics {

//<editor-fold defaultstate="collapsed" desc="ForceAttributes">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp", line = 21,
 FQN="ForceAttributes", NM="_ZL15ForceAttributes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp -nm=_ZL15ForceAttributes")
//</editor-fold>
public static listStringBool ForceAttributes/*J*/= new listStringBool($("force-attribute"), OptionHidden.Hidden, 
    new desc($("Add an attribute to a function. This should be a pair of 'function-name:attribute-name', for example -force-attribute=foo:noinline. This option can be specified multiple times.")));
//<editor-fold defaultstate="collapsed" desc="parseAttrKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp", line = 28,
 FQN="parseAttrKind", NM="_ZL13parseAttrKindN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp -nm=_ZL13parseAttrKindN4llvm9StringRefE")
//</editor-fold>
public static Attribute.AttrKind parseAttrKind(StringRef Kind) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// If F has any forced attributes given on the command line, add them.
//<editor-fold defaultstate="collapsed" desc="addForcedAttributes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp", line = 65,
 FQN="addForcedAttributes", NM="_ZL19addForcedAttributesRN4llvm8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp -nm=_ZL19addForcedAttributesRN4llvm8FunctionE")
//</editor-fold>
public static void addForcedAttributes(final Function /*&*/ F) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="initializeForceFunctionAttrsLegacyPassPassOnce">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp", line = 117,
 FQN="initializeForceFunctionAttrsLegacyPassPassOnce", NM="_ZL46initializeForceFunctionAttrsLegacyPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp -nm=_ZL46initializeForceFunctionAttrsLegacyPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeForceFunctionAttrsLegacyPassPassOnce(final PassRegistry /*&*/ Registry) {
  PassInfo /*P*/ PI = new PassInfo($("Force set function attributes"), $("forceattrs"), $AddrOf(ForceFunctionAttrsLegacyPass.ID),
          () -> new ForceFunctionAttrsLegacyPass(), false, false);
  Registry.registerPass($Deref(PI), true);
  return PI;
}

//<editor-fold defaultstate="collapsed" desc="InitializeForceFunctionAttrsLegacyPassPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp", line = 117,
 FQN="InitializeForceFunctionAttrsLegacyPassPassFlag", NM="_ZL46InitializeForceFunctionAttrsLegacyPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp -nm=_ZL46InitializeForceFunctionAttrsLegacyPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeForceFunctionAttrsLegacyPassPassFlag/*J*/= new std.once_flag();
} // END OF class ForceFunctionAttrsStatics
