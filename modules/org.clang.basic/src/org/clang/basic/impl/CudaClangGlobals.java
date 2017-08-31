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
package org.clang.basic.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type CudaClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang16CudaArchToStringENS_8CudaArchE;_ZN5clang16StringToCudaArchEN4llvm9StringRefE;_ZN5clang19CudaVersionToStringENS_11CudaVersionE;_ZN5clang21MinVersionForCudaArchENS_8CudaArchE;_ZN5clang22VirtualArchForCudaArchENS_8CudaArchE;_ZN5clang23CudaVirtualArchToStringENS_15CudaVirtualArchE;_ZN5clang23StringToCudaVirtualArchEN4llvm9StringRefE; -static-type=CudaClangGlobals -package=org.clang.basic.impl")
//</editor-fold>
public final class CudaClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::CudaVersionToString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 9,
 FQN="clang::CudaVersionToString", NM="_ZN5clang19CudaVersionToStringENS_11CudaVersionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang19CudaVersionToStringENS_11CudaVersionE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ CudaVersionToString(CudaVersion V) {
  switch (V) {
   case UNKNOWN:
    return $unknown;
   case CUDA_70:
    return $("7.0");
   case CUDA_75:
    return $("7.5");
   case CUDA_80:
    return $("8.0");
  }
  throw new llvm_unreachable("invalid enum");
}

//<editor-fold defaultstate="collapsed" desc="clang::CudaArchToString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 23,
 FQN="clang::CudaArchToString", NM="_ZN5clang16CudaArchToStringENS_8CudaArchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang16CudaArchToStringENS_8CudaArchE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ CudaArchToString(CudaArch A) {
  switch (A) {
   case UNKNOWN:
    return $unknown;
   case SM_20:
    return $("sm_20");
   case SM_21:
    return $("sm_21");
   case SM_30:
    return $("sm_30");
   case SM_32:
    return $("sm_32");
   case SM_35:
    return $("sm_35");
   case SM_37:
    return $("sm_37");
   case SM_50:
    return $("sm_50");
   case SM_52:
    return $("sm_52");
   case SM_53:
    return $("sm_53");
   case SM_60:
    return $("sm_60");
   case SM_61:
    return $("sm_61");
   case SM_62:
    return $("sm_62");
  }
  throw new llvm_unreachable("invalid enum");
}


// The input should have the form "sm_20".
//<editor-fold defaultstate="collapsed" desc="clang::StringToCudaArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 55,
 FQN="clang::StringToCudaArch", NM="_ZN5clang16StringToCudaArchEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang16StringToCudaArchEN4llvm9StringRefE")
//</editor-fold>
public static CudaArch StringToCudaArch(StringRef S) {
  return new StringSwitch<CudaArch>(/*NO_COPY*/S).
      Case(/*KEEP_STR*/"sm_20", CudaArch.SM_20).
      Case(/*KEEP_STR*/"sm_21", CudaArch.SM_21).
      Case(/*KEEP_STR*/"sm_30", CudaArch.SM_30).
      Case(/*KEEP_STR*/"sm_32", CudaArch.SM_32).
      Case(/*KEEP_STR*/"sm_35", CudaArch.SM_35).
      Case(/*KEEP_STR*/"sm_37", CudaArch.SM_37).
      Case(/*KEEP_STR*/"sm_50", CudaArch.SM_50).
      Case(/*KEEP_STR*/"sm_52", CudaArch.SM_52).
      Case(/*KEEP_STR*/"sm_53", CudaArch.SM_53).
      Case(/*KEEP_STR*/"sm_60", CudaArch.SM_60).
      Case(/*KEEP_STR*/"sm_61", CudaArch.SM_61).
      Case(/*KEEP_STR*/"sm_62", CudaArch.SM_62).
      Default(CudaArch.UNKNOWN);
}

//<editor-fold defaultstate="collapsed" desc="clang::CudaVirtualArchToString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 72,
 FQN="clang::CudaVirtualArchToString", NM="_ZN5clang23CudaVirtualArchToStringENS_15CudaVirtualArchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang23CudaVirtualArchToStringENS_15CudaVirtualArchE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ CudaVirtualArchToString(CudaVirtualArch A) {
  switch (A) {
   case UNKNOWN:
    return $unknown;
   case COMPUTE_20:
    return $("compute_20");
   case COMPUTE_30:
    return $("compute_30");
   case COMPUTE_32:
    return $("compute_32");
   case COMPUTE_35:
    return $("compute_35");
   case COMPUTE_37:
    return $("compute_37");
   case COMPUTE_50:
    return $("compute_50");
   case COMPUTE_52:
    return $("compute_52");
   case COMPUTE_53:
    return $("compute_53");
   case COMPUTE_60:
    return $("compute_60");
   case COMPUTE_61:
    return $("compute_61");
   case COMPUTE_62:
    return $("compute_62");
  }
  throw new llvm_unreachable("invalid enum");
}


// The input should have the form "compute_20".
//<editor-fold defaultstate="collapsed" desc="clang::StringToCudaVirtualArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 102,
 FQN="clang::StringToCudaVirtualArch", NM="_ZN5clang23StringToCudaVirtualArchEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang23StringToCudaVirtualArchEN4llvm9StringRefE")
//</editor-fold>
public static CudaVirtualArch StringToCudaVirtualArch(StringRef S) {
  return new StringSwitch<CudaVirtualArch>(/*NO_COPY*/S).
      Case(/*KEEP_STR*/"compute_20", CudaVirtualArch.COMPUTE_20).
      Case(/*KEEP_STR*/"compute_30", CudaVirtualArch.COMPUTE_30).
      Case(/*KEEP_STR*/"compute_32", CudaVirtualArch.COMPUTE_32).
      Case(/*KEEP_STR*/"compute_35", CudaVirtualArch.COMPUTE_35).
      Case(/*KEEP_STR*/"compute_37", CudaVirtualArch.COMPUTE_37).
      Case(/*KEEP_STR*/"compute_50", CudaVirtualArch.COMPUTE_50).
      Case(/*KEEP_STR*/"compute_52", CudaVirtualArch.COMPUTE_52).
      Case(/*KEEP_STR*/"compute_53", CudaVirtualArch.COMPUTE_53).
      Case(/*KEEP_STR*/"compute_60", CudaVirtualArch.COMPUTE_60).
      Case(/*KEEP_STR*/"compute_61", CudaVirtualArch.COMPUTE_61).
      Case(/*KEEP_STR*/"compute_62", CudaVirtualArch.COMPUTE_62).
      Default(CudaVirtualArch.UNKNOWN);
}


/// Get the compute_xx corresponding to an sm_yy.
//<editor-fold defaultstate="collapsed" desc="clang::VirtualArchForCudaArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 118,
 FQN="clang::VirtualArchForCudaArch", NM="_ZN5clang22VirtualArchForCudaArchENS_8CudaArchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang22VirtualArchForCudaArchENS_8CudaArchE")
//</editor-fold>
public static CudaVirtualArch VirtualArchForCudaArch(CudaArch A) {
  switch (A) {
   case UNKNOWN:
    return CudaVirtualArch.UNKNOWN;
   case SM_20:
   case SM_21:
    return CudaVirtualArch.COMPUTE_20;
   case SM_30:
    return CudaVirtualArch.COMPUTE_30;
   case SM_32:
    return CudaVirtualArch.COMPUTE_32;
   case SM_35:
    return CudaVirtualArch.COMPUTE_35;
   case SM_37:
    return CudaVirtualArch.COMPUTE_37;
   case SM_50:
    return CudaVirtualArch.COMPUTE_50;
   case SM_52:
    return CudaVirtualArch.COMPUTE_52;
   case SM_53:
    return CudaVirtualArch.COMPUTE_53;
   case SM_60:
    return CudaVirtualArch.COMPUTE_60;
   case SM_61:
    return CudaVirtualArch.COMPUTE_61;
   case SM_62:
    return CudaVirtualArch.COMPUTE_62;
  }
  throw new llvm_unreachable("invalid enum");
}


/// Get the earliest CudaVersion that supports the given CudaArch.
//<editor-fold defaultstate="collapsed" desc="clang::MinVersionForCudaArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 149,
 FQN="clang::MinVersionForCudaArch", NM="_ZN5clang21MinVersionForCudaArchENS_8CudaArchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang21MinVersionForCudaArchENS_8CudaArchE")
//</editor-fold>
public static CudaVersion MinVersionForCudaArch(CudaArch A) {
  switch (A) {
   case UNKNOWN:
    return CudaVersion.UNKNOWN;
   case SM_20:
   case SM_21:
   case SM_30:
   case SM_32:
   case SM_35:
   case SM_37:
   case SM_50:
   case SM_52:
   case SM_53:
    return CudaVersion.CUDA_70;
   case SM_60:
   case SM_61:
   case SM_62:
    return CudaVersion.CUDA_80;
  }
  throw new llvm_unreachable("invalid enum");
}

} // END OF class CudaClangGlobals
