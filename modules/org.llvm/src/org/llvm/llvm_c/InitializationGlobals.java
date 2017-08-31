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
package org.llvm.llvm_c;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.object.*;
import org.llvm.llvmc.*;
import org.llvm.java.LlvmFunctionPointers.*;
import org.llvm.debuginfo.*;
import org.llvm.llvmc.java.LlvmCFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type InitializationGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.llvm_c.InitializationGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/Instrumentation.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARC.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/Utils.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/Vectorize.cpp -nm=_Z17LLVMInitializeIPO;_Z24LLVMInitializeScalarOpts;_Z25LLVMInitializeInstCombine;_Z25LLVMInitializeObjCARCOpts;_Z27LLVMInitializeVectorization;_Z28LLVMInitializeTransformUtils;_Z29LLVMInitializeInstrumentation; -static-type=InitializationGlobals -package=org.llvm.llvm_c")
//</editor-fold>
public final class InitializationGlobals {


/// LLVMInitializeTransformUtils - C binding for initializeTransformUtilsPasses.
//<editor-fold defaultstate="collapsed" desc="LLVMInitializeTransformUtils">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Utils.cpp", line = 41,
 FQN="LLVMInitializeTransformUtils", NM="_Z28LLVMInitializeTransformUtils",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Utils.cpp -nm=_Z28LLVMInitializeTransformUtils")
//</editor-fold>
public static void LLVMInitializeTransformUtils( LLVMOpaquePassRegistry /*P*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInitializeScalarOpts">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 95,
 FQN="LLVMInitializeScalarOpts", NM="_Z24LLVMInitializeScalarOpts",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_Z24LLVMInitializeScalarOpts")
//</editor-fold>
public static void LLVMInitializeScalarOpts( LLVMOpaquePassRegistry /*P*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInitializeObjCARCOpts">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARC.cpp", line = 39,
 FQN="LLVMInitializeObjCARCOpts", NM="_Z25LLVMInitializeObjCARCOpts",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARC.cpp -nm=_Z25LLVMInitializeObjCARCOpts")
//</editor-fold>
public static void LLVMInitializeObjCARCOpts( LLVMOpaquePassRegistry /*P*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInitializeVectorization">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/Vectorize.cpp", line = 35,
 FQN="LLVMInitializeVectorization", NM="_Z27LLVMInitializeVectorization",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/Vectorize.cpp -nm=_Z27LLVMInitializeVectorization")
//</editor-fold>
public static void LLVMInitializeVectorization( LLVMOpaquePassRegistry /*P*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInitializeInstCombine">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp", line = 3217,
 FQN="LLVMInitializeInstCombine", NM="_Z25LLVMInitializeInstCombine",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_Z25LLVMInitializeInstCombine")
//</editor-fold>
public static void LLVMInitializeInstCombine( LLVMOpaquePassRegistry /*P*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMInitializeIPO">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 60,
 FQN="LLVMInitializeIPO", NM="_Z17LLVMInitializeIPO",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_Z17LLVMInitializeIPO")
//</editor-fold>
public static void LLVMInitializeIPO( LLVMOpaquePassRegistry /*P*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// LLVMInitializeInstrumentation - C binding for
/// initializeInstrumentation.
//<editor-fold defaultstate="collapsed" desc="LLVMInitializeInstrumentation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/Instrumentation.cpp", line = 76,
 FQN="LLVMInitializeInstrumentation", NM="_Z29LLVMInitializeInstrumentation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/Instrumentation.cpp -nm=_Z29LLVMInitializeInstrumentation")
//</editor-fold>
public static void LLVMInitializeInstrumentation( LLVMOpaquePassRegistry /*P*/ R) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class InitializationGlobals
