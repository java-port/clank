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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.java.ClankAliases;
import org.clang.basic.target.*;


//<editor-fold defaultstate="collapsed" desc="static type ModuleStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZL10hasFeatureN4llvm9StringRefERKN5clang11LangOptionsERKNS1_10TargetInfoE;_ZL13printModuleIdRN4llvm11raw_ostreamERKNS_11SmallVectorISt4pairISsN5clang14SourceLocationEELj2EEE; -static-type=ModuleStatics -package=org.clang.basic.impl")
//</editor-fold>
public final class ModuleStatics {


/// \brief Determine whether a translation unit built using the current
/// language options has the given feature.
//<editor-fold defaultstate="collapsed" desc="hasFeature">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 60,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 59,
 FQN="hasFeature", NM="_ZL10hasFeatureN4llvm9StringRefERKN5clang11LangOptionsERKNS1_10TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZL10hasFeatureN4llvm9StringRefERKN5clang11LangOptionsERKNS1_10TargetInfoE")
//</editor-fold>
public static boolean hasFeature(StringRef Feature, /*const*/ LangOptions /*&*/ LangOpts, 
          /*const*/ TargetInfo /*&*/ Target) {
  boolean HasFeature = new StringSwitchBool(/*NO_COPY*/Feature).
      Case(/*KEEP_STR*/"altivec", LangOpts.AltiVec).
      Case(/*KEEP_STR*/"blocks", LangOpts.Blocks).
      Case(/*KEEP_STR*/"cplusplus", LangOpts.CPlusPlus).
      Case(/*KEEP_STR*/"cplusplus11", LangOpts.CPlusPlus11).
      Case(/*KEEP_STR*/"objc", LangOpts.ObjC1).
      Case(/*KEEP_STR*/"objc_arc", LangOpts.ObjCAutoRefCount).
      Case(/*KEEP_STR*/"opencl", LangOpts.OpenCL).
      Case(/*KEEP_STR*/"tls", Target.isTLSSupported()).
      Case(/*KEEP_STR*/"zvector", LangOpts.ZVector).
      Default(Target.hasFeature(new StringRef(Feature)));
  if (!HasFeature) {
    HasFeature = $noteq___normal_iterator$C(std.find(LangOpts.ModuleFeatures.begin(), 
            LangOpts.ModuleFeatures.end(), 
            Feature), LangOpts.ModuleFeatures.end());
  }
  return HasFeature;
}

//<editor-fold defaultstate="collapsed" desc="printModuleId">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", line = 233,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp", old_line = 200,
 FQN="printModuleId", NM="_ZL13printModuleIdRN4llvm11raw_ostreamERKNS_11SmallVectorISt4pairISsN5clang14SourceLocationEELj2EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Module.cpp -nm=_ZL13printModuleIdRN4llvm11raw_ostreamERKNS_11SmallVectorISt4pairISsN5clang14SourceLocationEELj2EEE")
//</editor-fold>
public static void printModuleId(raw_ostream /*&*/ OS, /*const*/ClankAliases.ModuleId/*&*/ Id) {
  for (/*uint*/int I = 0, N = Id.size(); I != N; ++I) {
    if ((I != 0)) {
      OS.$out(/*KEEP_STR*/$DOT);
    }
    OS.$out(Id.$at(I).first);
  }
}

} // END OF class ModuleStatics
