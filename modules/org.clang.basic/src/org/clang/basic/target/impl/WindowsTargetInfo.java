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

package org.clang.basic.target.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.target.*;


// Windows target
/*template <typename Target> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 701,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 653,
 FQN="(anonymous namespace)::WindowsTargetInfo", NM="_ZN12_GLOBAL__N_117WindowsTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117WindowsTargetInfoE")
//</editor-fold>
public class WindowsTargetInfo</*typename*/ Target extends TargetInfo>  extends /*public*/ OSTargetInfo<Target> {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsTargetInfo::getOSDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 704,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 656,
   FQN="(anonymous namespace)::WindowsTargetInfo::getOSDefines", NM="_ZNK12_GLOBAL__N_117WindowsTargetInfo12getOSDefinesERKN5clang11LangOptionsERKN4llvm6TripleERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117WindowsTargetInfo12getOSDefinesERKN5clang11LangOptionsERKN4llvm6TripleERNS1_12MacroBuilderE")
  //</editor-fold>
  protected void getOSDefines(/*const*/ LangOptions /*&*/ Opts, /*const*/ Triple /*&*/ Triple, 
              MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_WIN32"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsTargetInfo::getVisualStudioDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 708,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 660,
   FQN="(anonymous namespace)::WindowsTargetInfo::getVisualStudioDefines", NM="_ZNK12_GLOBAL__N_117WindowsTargetInfo22getVisualStudioDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117WindowsTargetInfo22getVisualStudioDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  protected void getVisualStudioDefines(/*const*/ LangOptions /*&*/ Opts, 
                        MacroBuilder /*&*/ Builder) /*const*/ {
    if (Opts.CPlusPlus) {
      if (Opts.RTTIData) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"_CPPRTTI"));
      }
      if (Opts.CXXExceptions) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"_CPPUNWIND"));
      }
    }
    if (Opts.Bool) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__BOOL_DEFINED"));
    }
    if (!Opts.CharIsSigned) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_CHAR_UNSIGNED"));
    }
    
    // FIXME: POSIXThreads isn't exactly the option this should be defined for,
    //        but it works for now.
    if (Opts.POSIXThreads) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_MT"));
    }
    if ((Opts.MSCompatibilityVersion != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_MSC_VER"), 
          new Twine(JD$UInt.INSTANCE, Opts.MSCompatibilityVersion / 100000));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_MSC_FULL_VER"), new Twine(JD$UInt.INSTANCE, Opts.MSCompatibilityVersion));
      // FIXME We cannot encode the revision information into 32-bits
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_MSC_BUILD"), new Twine(JD$Int.INSTANCE, 1));
      if (Opts.CPlusPlus11 && Opts.isCompatibleWithMSVC(LangOptions.MSVCMajorVersion.MSVC2015)) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"_HAS_CHAR16_T_LANGUAGE_SUPPORT"), new Twine(JD$Int.INSTANCE, 1));
      }
      if (Opts.isCompatibleWithMSVC(LangOptions.MSVCMajorVersion.MSVC2015)) {
        if (Opts.CPlusPlus1z) {
          Builder.defineMacro(new Twine(/*KEEP_STR*/"_MSVC_LANG"), new Twine(/*KEEP_STR*/"201403L"));
        } else if (Opts.CPlusPlus14) {
          Builder.defineMacro(new Twine(/*KEEP_STR*/"_MSVC_LANG"), new Twine(/*KEEP_STR*/"201402L"));
        }
      }
    }
    if (Opts.MicrosoftExt) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_MSC_EXTENSIONS"));
      if (Opts.CPlusPlus11) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"_RVALUE_REFERENCES_V2_SUPPORTED"));
        Builder.defineMacro(new Twine(/*KEEP_STR*/"_RVALUE_REFERENCES_SUPPORTED"));
        Builder.defineMacro(new Twine(/*KEEP_STR*/"_NATIVE_NULLPTR_SUPPORTED"));
      }
    }
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_INTEGRAL_MAX_BITS"), new Twine(/*KEEP_STR*/"64"));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WindowsTargetInfo::WindowsTargetInfo<Target>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 761,
   FQN="(anonymous namespace)::WindowsTargetInfo::WindowsTargetInfo<Target>", NM="_ZN12_GLOBAL__N_117WindowsTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117WindowsTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public WindowsTargetInfo(Target T, /*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : OSTargetInfo<Target>(Triple, Opts)*/ 
    //START JInit
    /*ParenListExpr*/super(T, Triple, Opts);
    //END JInit
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
