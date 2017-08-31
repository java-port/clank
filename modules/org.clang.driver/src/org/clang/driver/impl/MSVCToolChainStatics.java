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
package org.clang.driver.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.option.*;
import org.clang.driver.*;
;
import org.llvm.support.sys.*;;


//<editor-fold defaultstate="collapsed" desc="static type MSVCToolChainStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZL13TranslateDArgPN4llvm3opt3ArgERNS0_14DerivedArgListERKNS0_8OptTableE;_ZL15TranslateOptArgPN4llvm3opt3ArgERNS0_14DerivedArgListEbPKcRKNS0_8OptTableE;_ZL17getWindowsSDKArchN4llvm6Triple8ArchTypeE;_ZL22getWindows10SDKVersionRKSsRSs;_ZL23getSystemRegistryStringPKcS0_RSsPSs; -static-type=MSVCToolChainStatics -package=org.clang.driver.impl")
//</editor-fold>
public final class MSVCToolChainStatics {


/// \brief Read registry string.
/// This also supports a means to look for high-versioned keys by use
/// of a $VERSION placeholder in the key path.
/// $VERSION in the key path is a placeholder for the version number,
/// causing the highest value path to be searched for and used.
/// I.e. "SOFTWARE\\Microsoft\\VisualStudio\\$VERSION".
/// There can be additional characters in the component.  Only the numeric
/// characters are compared.  This function only searches HKLM.
//<editor-fold defaultstate="collapsed" desc="getSystemRegistryString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 134,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 120,
 FQN="getSystemRegistryString", NM="_ZL23getSystemRegistryStringPKcS0_RSsPSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZL23getSystemRegistryStringPKcS0_RSsPSs")
//</editor-fold>
public static boolean getSystemRegistryString(/*const*/char$ptr/*char P*/ keyPath, /*const*/char$ptr/*char P*/ valueName, 
                       std.string/*&*/ value, std.string/*P*/ phValue) {
  return false;
  // USE_WIN32
}


// Convert LLVM's ArchType
// to the corresponding name of Windows SDK libraries subfolder
//<editor-fold defaultstate="collapsed" desc="getWindowsSDKArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 225,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 210,
 FQN="getWindowsSDKArch", NM="_ZL17getWindowsSDKArchN4llvm6Triple8ArchTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZL17getWindowsSDKArchN4llvm6Triple8ArchTypeE")
//</editor-fold>
public static StringRef getWindowsSDKArch(Triple.ArchType Arch) {
  switch (Arch) {
   case x86:
    return new StringRef(/*KEEP_STR*/"x86");
   case x86_64:
    return new StringRef(/*KEEP_STR*/"x64");
   case arm:
    return new StringRef(/*KEEP_STR*/"arm");
   default:
    return new StringRef(/*KEEP_STR*/$EMPTY);
  }
}


// Find the most recent version of Universal CRT or Windows 10 SDK.
// vcvarsqueryregistry.bat from Visual Studio 2015 sorts entries in the include
// directory by name and uses the last one of the list.
// So we compare entry names lexicographically to find the greatest one.
//<editor-fold defaultstate="collapsed" desc="getWindows10SDKVersion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 242,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 227,
 FQN="getWindows10SDKVersion", NM="_ZL22getWindows10SDKVersionRKSsRSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZL22getWindows10SDKVersionRKSsRSs")
//</editor-fold>
public static boolean getWindows10SDKVersion(/*const*/std.string/*&*/ SDKPath, 
                      std.string/*&*/ SDKVersion) {
  SDKVersion.clear();
  
  std.error_code EC/*J*/= new std.error_code();
  SmallString/*128*/ IncludePath/*J*/= new SmallString/*128*/(new StringRef(SDKPath), 128);
  path.append(IncludePath, new Twine(/*KEEP_STR*/"Include"));
  fs.directory_iterator DirIt = null;
  fs.directory_iterator DirEnd = null;
  try {
    for (DirIt/*J*/= new fs.directory_iterator(new Twine(IncludePath), EC), DirEnd/*J*/= new fs.directory_iterator();
         DirIt.$noteq(DirEnd) && !EC.$bool(); DirIt.increment(EC)) {
      if (!fs.is_directory(new Twine(DirIt.$arrow().getPath()))) {
        continue;
      }
      StringRef CandidateName = path.filename(new StringRef(DirIt.$arrow().getPath()));
      // If WDK is installed, there could be subfolders like "wdf" in the
      // "Include" directory.
      // Allow only directories which names start with "10.".
      if (!CandidateName.startswith(/*STRINGREF_STR*/"10.")) {
        continue;
      }
      if ($greater_StringRef(/*NO_COPY*/CandidateName, new StringRef(SDKVersion))) {
        SDKVersion.$assignMove(CandidateName.$string());
      }
    }
  } finally {
    if (DirEnd != null) { DirEnd.$destroy(); }
    if (DirIt != null) { DirIt.$destroy(); }
  }
  
  return !SDKVersion.empty();
}

//<editor-fold defaultstate="collapsed" desc="TranslateOptArg">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 698,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 637,
 FQN="TranslateOptArg", NM="_ZL15TranslateOptArgPN4llvm3opt3ArgERNS0_14DerivedArgListEbPKcRKNS0_8OptTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZL15TranslateOptArgPN4llvm3opt3ArgERNS0_14DerivedArgListEbPKcRKNS0_8OptTableE")
//</editor-fold>
public static void TranslateOptArg(Arg /*P*/ A, DerivedArgList /*&*/ DAL, 
               boolean SupportsForcingFramePointer, 
               /*const*/char$ptr/*char P*/ ExpandChar, /*const*/ OptTable /*&*/ Opts) {
  assert (A.getOption().matches(new OptSpecifier(options.ID.OPT__SLASH_O.getValue())));
  
  StringRef OptStr = new StringRef(A.getValue());
  for (/*size_t*/int I = 0, E = OptStr.size(); I != E; ++I) {
    /*const*/char$ref/*char &*/ OptChar = (OptStr.data().$add(I)).star$ref();
    switch (OptChar.$deref()) {
     default:
      break;
     case '1':
     case '2':
     case 'x':
     case 'd':
      if ($eq_ptr(OptChar.deref$ptr(), ExpandChar)) {
        if (OptChar.$deref() == $$d) {
          DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_O0.getValue())));
        } else {
          if (OptChar.$deref() == $$1) {
            DAL.AddJoinedArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_O.getValue())), new StringRef(/*KEEP_STR*/$s));
          } else if (OptChar.$deref() == $$2 || OptChar.$deref() == $$x) {
            DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_fbuiltin.getValue())));
            DAL.AddJoinedArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_O.getValue())), new StringRef(/*KEEP_STR*/$2));
          }
          if (SupportsForcingFramePointer
             && !DAL.hasArgNoClaim(new OptSpecifier(options.ID.OPT_fno_omit_frame_pointer.getValue()))) {
            DAL.AddFlagArg(A, 
                Opts.getOption(new OptSpecifier(options.ID.OPT_fomit_frame_pointer.getValue())));
          }
          if (OptChar.$deref() == $$1 || OptChar.$deref() == $$2) {
            DAL.AddFlagArg(A, 
                Opts.getOption(new OptSpecifier(options.ID.OPT_ffunction_sections.getValue())));
          }
        }
      }
      break;
     case 'b':
      if (I + 1 != E && (isdigit(OptStr.$at(I + 1)) != 0)) {
        switch (OptStr.$at(I + 1)) {
         case '0':
          DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_fno_inline.getValue())));
          break;
         case '1':
          DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_finline_hint_functions.getValue())));
          break;
         case '2':
          DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_finline_functions.getValue())));
          break;
        }
        ++I;
      }
      break;
     case 'g':
      break;
     case 'i':
      if (I + 1 != E && OptStr.$at(I + 1) == $$MINUS) {
        ++I;
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_fno_builtin.getValue())));
      } else {
        DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_fbuiltin.getValue())));
      }
      break;
     case 's':
      DAL.AddJoinedArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_O.getValue())), new StringRef(/*KEEP_STR*/$s));
      break;
     case 't':
      DAL.AddJoinedArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_O.getValue())), new StringRef(/*KEEP_STR*/$2));
      break;
     case 'y':
      {
        boolean OmitFramePointer = true;
        if (I + 1 != E && OptStr.$at(I + 1) == $$MINUS) {
          OmitFramePointer = false;
          ++I;
        }
        if (SupportsForcingFramePointer) {
          if (OmitFramePointer) {
            DAL.AddFlagArg(A, 
                Opts.getOption(new OptSpecifier(options.ID.OPT_fomit_frame_pointer.getValue())));
          } else {
            DAL.AddFlagArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_fno_omit_frame_pointer.getValue())));
          }
        } else {
          // Don't warn about /Oy- in 64-bit builds (where
          // SupportsForcingFramePointer is false).  The flag having no effect
          // there is a compiler-internal optimization, and people shouldn't have
          // to special-case their build files for 64-bit clang-cl.
          A.claim();
        }
        break;
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="TranslateDArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 791,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 711,
 FQN="TranslateDArg", NM="_ZL13TranslateDArgPN4llvm3opt3ArgERNS0_14DerivedArgListERKNS0_8OptTableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZL13TranslateDArgPN4llvm3opt3ArgERNS0_14DerivedArgListERKNS0_8OptTableE")
//</editor-fold>
public static void TranslateDArg(Arg /*P*/ A, DerivedArgList /*&*/ DAL, 
             /*const*/ OptTable /*&*/ Opts) {
  assert (A.getOption().matches(new OptSpecifier(options.ID.OPT_D.getValue())));
  
  StringRef Val = new StringRef(A.getValue());
  /*size_t*/int Hash = Val.find($$HASH);
  if (Hash == StringRef.npos || $greater_uint(Hash, Val.find($$EQ))) {
    DAL.append(A);
    return;
  }
  
  std.string NewVal = Val.$string();
  NewVal.$set(Hash, $$EQ);
  DAL.AddJoinedArg(A, Opts.getOption(new OptSpecifier(options.ID.OPT_D.getValue())), new StringRef(NewVal));
}

} // END OF class MSVCToolChainStatics
