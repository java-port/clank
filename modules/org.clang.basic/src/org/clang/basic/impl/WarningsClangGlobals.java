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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;

import org.clang.basic.diag.*;
import static org.clang.basic.impl.WarningsStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type WarningsClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Warnings.cpp -nm=_ZN5clang21ProcessWarningOptionsERNS_17DiagnosticsEngineERKNS_17DiagnosticOptionsEb; -static-type=WarningsClangGlobals -package=org.clang.basic.impl ")
//</editor-fold>
public final class WarningsClangGlobals {


/// ProcessWarningOptions - Initialize the diagnostic client and process the
/// warning options specified on the command line.
//<editor-fold defaultstate="collapsed" desc="clang::ProcessWarningOptions">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Warnings.cpp", line = 44,
 FQN="clang::ProcessWarningOptions", NM="_ZN5clang21ProcessWarningOptionsERNS_17DiagnosticsEngineERKNS_17DiagnosticOptionsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Warnings.cpp -nm=_ZN5clang21ProcessWarningOptionsERNS_17DiagnosticsEngineERKNS_17DiagnosticOptionsEb")
//</editor-fold>
public static void ProcessWarningOptions(DiagnosticsEngine /*&*/ Diags, 
                     /*const*/ DiagnosticOptions /*&*/ Opts) {
  ProcessWarningOptions(Diags, 
                     Opts, 
                     true);
}
public static void ProcessWarningOptions(DiagnosticsEngine /*&*/ Diags, 
                     /*const*/ DiagnosticOptions /*&*/ Opts, 
                     boolean ReportDiags/*= true*/) {
  Diags.setSuppressSystemWarnings(true); // Default to -Wno-system-headers
  Diags.setIgnoreAllWarnings(Opts.IgnoreWarnings);
  Diags.setShowOverloads(Opts.getShowOverloads());
  
  Diags.setElideType(Opts.ElideType);
  Diags.setPrintTemplateTree(Opts.ShowTemplateTree);
  Diags.setShowColors(Opts.ShowColors);
  
  // Handle -ferror-limit
  if ((Opts.ErrorLimit != 0)) {
    Diags.setErrorLimit(Opts.ErrorLimit);
  }
  if ((Opts.TemplateBacktraceLimit != 0)) {
    Diags.setTemplateBacktraceLimit(Opts.TemplateBacktraceLimit);
  }
  if ((Opts.ConstexprBacktraceLimit != 0)) {
    Diags.setConstexprBacktraceLimit(Opts.ConstexprBacktraceLimit);
  }
  
  // If -pedantic or -pedantic-errors was specified, then we want to map all
  // extension diagnostics onto WARNING or ERROR unless the user has futz'd
  // around with them explicitly.
  if (Opts.PedanticErrors) {
    Diags.setExtensionHandlingBehavior(diag.Severity.Error);
  } else if (Opts.Pedantic) {
    Diags.setExtensionHandlingBehavior(diag.Severity.Warning);
  } else {
    Diags.setExtensionHandlingBehavior(diag.Severity.Ignored);
  }
  
  SmallVectorUInt _Diags/*J*/= new SmallVectorUInt(10, 0);
  /*const*/ IntrusiveRefCntPtr<DiagnosticIDs> DiagIDs = new IntrusiveRefCntPtr<DiagnosticIDs>(Diags.getDiagnosticIDs());
  // We parse the warning options twice.  The first pass sets diagnostic state,
  // while the second pass reports warnings/errors.  This has the effect that
  // we follow the more canonical "last option wins" paradigm when there are 
  // conflicting options.
  for (/*uint*/int Report = 0, ReportEnd = 2; Report != ReportEnd; ++Report) {
    boolean SetDiagnostic = (Report == 0);
    
    // If we've set the diagnostic state and are not reporting diagnostics then
    // we're done.
    if (!SetDiagnostic && !ReportDiags) {
      break;
    }
    
    for (/*uint*/int i = 0, e = Opts.Warnings.size(); i != e; ++i) {
      /*const*/ Flavor _Flavor = diag.Flavor.WarningOrError;
      StringRef Opt = new StringRef(Opts.Warnings.$at(i));
      StringRef OrigOpt = new StringRef(Opts.Warnings.$at(i));
      
      // Treat -Wformat=0 as an alias for -Wno-format.
      if ($eq_StringRef(/*NO_COPY*/Opt, /*STRINGREF_STR*/"format=0")) {
        Opt.$assignMove(/*STRINGREF_STR*/"no-format");
      }
      
      // Check to see if this warning starts with "no-", if so, this is a
      // negative form of the option.
      boolean isPositive = true;
      if (Opt.startswith(/*STRINGREF_STR*/"no-")) {
        isPositive = false;
        Opt.$assignMove(Opt.substr(3));
      }
      
      // Figure out how this option affects the warning.  If -Wfoo, map the
      // diagnostic to a warning, if -Wno-foo, map it to ignore.
      diag.Severity Mapping = isPositive ? diag.Severity.Warning : diag.Severity.Ignored;
      
      // -Wsystem-headers is a special case, not driven by the option table.  It
      // cannot be controlled with -Werror.
      if ($eq_StringRef(/*NO_COPY*/Opt, /*STRINGREF_STR*/"system-headers")) {
        if (SetDiagnostic) {
          Diags.setSuppressSystemWarnings(!isPositive);
        }
        continue;
      }
      
      // -Weverything is a special case as well.  It implicitly enables all
      // warnings, including ones not explicitly in a warning group.
      if ($eq_StringRef(/*NO_COPY*/Opt, /*STRINGREF_STR*/"everything")) {
        if (SetDiagnostic) {
          if (isPositive) {
            Diags.setEnableAllWarnings(true);
          } else {
            Diags.setEnableAllWarnings(false);
            Diags.setSeverityForAll(_Flavor, diag.Severity.Ignored);
          }
        }
        continue;
      }
      
      // -Werror/-Wno-error is a special case, not controlled by the option 
      // table. It also has the "specifier" form of -Werror=foo and -Werror-foo.
      if (Opt.startswith(/*STRINGREF_STR*/"error")) {
        StringRef Specifier/*J*/= new StringRef();
        if ($greater_uint(Opt.size(), 5)) { // Specifier must be present.
          if ((Opt.$at(5) != $$EQ && Opt.$at(5) != $$MINUS) || Opt.size() == 6) {
            if ((Report != 0)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.warn_unknown_warning_specifier)), 
                        /*KEEP_STR*/"-Werror"), new StringRef(($add_T_str(/*KEEP_STR*/"-W", OrigOpt.str())))));
              } finally {
                $c$.$destroy();
              }
            }
            continue;
          }
          Specifier.$assignMove(Opt.substr(6));
        }
        if (Specifier.empty()) {
          if (SetDiagnostic) {
            Diags.setWarningsAsErrors(isPositive);
          }
          continue;
        }
        if (SetDiagnostic) {
          // Set the warning as error flag for this specifier.
          Diags.setDiagnosticGroupWarningAsError(new StringRef(Specifier), isPositive);
        } else if (DiagIDs.$arrow().getDiagnosticsInGroup(_Flavor, new StringRef(Specifier), _Diags)) {
          EmitUnknownDiagWarning(Diags, _Flavor, new StringRef(/*KEEP_STR*/"-Werror="), new StringRef(Specifier));
        }
        continue;
      }
      
      // -Wfatal-errors is yet another special case.
      if (Opt.startswith(/*STRINGREF_STR*/"fatal-errors")) {
        StringRef Specifier/*J*/= new StringRef();
        if (Opt.size() != 12) {
          if ((Opt.$at(12) != $$EQ && Opt.$at(12) != $$MINUS) || Opt.size() == 13) {
            if ((Report != 0)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.warn_unknown_warning_specifier)), 
                        /*KEEP_STR*/"-Wfatal-errors"), new StringRef(($add_T_str(/*KEEP_STR*/"-W", OrigOpt.str())))));
              } finally {
                $c$.$destroy();
              }
            }
            continue;
          }
          Specifier.$assignMove(Opt.substr(13));
        }
        if (Specifier.empty()) {
          if (SetDiagnostic) {
            Diags.setErrorsAsFatal(isPositive);
          }
          continue;
        }
        if (SetDiagnostic) {
          // Set the error as fatal flag for this specifier.
          Diags.setDiagnosticGroupErrorAsFatal(new StringRef(Specifier), isPositive);
        } else if (DiagIDs.$arrow().getDiagnosticsInGroup(_Flavor, new StringRef(Specifier), _Diags)) {
          EmitUnknownDiagWarning(Diags, _Flavor, new StringRef(/*KEEP_STR*/"-Wfatal-errors="), new StringRef(Specifier));
        }
        continue;
      }
      if ((Report != 0)) {
        if (DiagIDs.$arrow().getDiagnosticsInGroup(_Flavor, new StringRef(Opt), _Diags)) {
          EmitUnknownDiagWarning(Diags, _Flavor, new StringRef(isPositive ? $("-W") : $("-Wno-")), 
              new StringRef(Opt));
        }
      } else {
        Diags.setSeverityForGroup(_Flavor, new StringRef(Opt), Mapping);
      }
    }
    
    for (/*uint*/int i = 0, e = Opts.Remarks.size(); i != e; ++i) {
      StringRef Opt = new StringRef(Opts.Remarks.$at(i));
      /*const*/ Flavor _Flavor = diag.Flavor.Remark;
      
      // Check to see if this warning starts with "no-", if so, this is a
      // negative form of the option.
      boolean IsPositive = !Opt.startswith(/*STRINGREF_STR*/"no-");
      if (!IsPositive) {
        Opt.$assignMove(Opt.substr(3));
      }
      
      Severity _Severity = IsPositive ? diag.Severity.Remark : diag.Severity.Ignored;
      
      // -Reverything sets the state of all remarks. Note that all remarks are
      // in remark groups, so we don't need a separate 'all remarks enabled'
      // flag.
      if ($eq_StringRef(/*NO_COPY*/Opt, /*STRINGREF_STR*/"everything")) {
        if (SetDiagnostic) {
          Diags.setSeverityForAll(_Flavor, _Severity);
        }
        continue;
      }
      if ((Report != 0)) {
        if (DiagIDs.$arrow().getDiagnosticsInGroup(_Flavor, new StringRef(Opt), _Diags)) {
          EmitUnknownDiagWarning(Diags, _Flavor, new StringRef(IsPositive ? $("-R") : $("-Rno-")), 
              new StringRef(Opt));
        }
      } else {
        Diags.setSeverityForGroup(_Flavor, new StringRef(Opt), 
            IsPositive ? diag.Severity.Remark : diag.Severity.Ignored);
      }
    }
  }
}

} // END OF class WarningsClangGlobals
