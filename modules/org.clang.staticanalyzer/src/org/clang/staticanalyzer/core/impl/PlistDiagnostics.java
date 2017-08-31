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

package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.llvm.DenseMapInfoFileID;
import static org.clang.basic.markup.MarkupGlobals.*;
import org.clang.staticanalyzer.core.StaticanalyzerClangGlobals;
import org.llvm.support.sys.fs;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PlistDiagnostics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 30,
 FQN="(anonymous namespace)::PlistDiagnostics", NM="_ZN12_GLOBAL__N_116PlistDiagnosticsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116PlistDiagnosticsE")
//</editor-fold>
public class PlistDiagnostics extends /*public*/ PathDiagnosticConsumer implements Destructors.ClassWithDestructor {
  private /*const*/std.string OutputFile;
  private final /*const*/ LangOptions /*&*/ LangOpts;
  private /*const*/boolean SupportsCrossFileDiagnostics;
/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PlistDiagnostics::PlistDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 59,
   FQN="(anonymous namespace)::PlistDiagnostics::PlistDiagnostics", NM="_ZN12_GLOBAL__N_116PlistDiagnosticsC1ERN5clang15AnalyzerOptionsERKSsRKNS1_11LangOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116PlistDiagnosticsC1ERN5clang15AnalyzerOptionsERKSsRKNS1_11LangOptionsEb")
  //</editor-fold>
  public PlistDiagnostics(final AnalyzerOptions /*&*/ AnalyzerOpts, 
      final /*const*/std.string/*&*/ output, 
      final /*const*/ LangOptions /*&*/ LO, 
      boolean supportsMultipleFiles) {
    // : PathDiagnosticConsumer(), OutputFile(output), LangOpts(LO), SupportsCrossFileDiagnostics(supportsMultipleFiles) 
    //START JInit
    super();
    this.OutputFile = new std.string(output);
    this./*&*/LangOpts=/*&*/LO;
    this.SupportsCrossFileDiagnostics = supportsMultipleFiles;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PlistDiagnostics::~PlistDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 40,
   FQN="(anonymous namespace)::PlistDiagnostics::~PlistDiagnostics", NM="_ZN12_GLOBAL__N_116PlistDiagnosticsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116PlistDiagnosticsD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    OutputFile.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PlistDiagnostics::FlushDiagnosticsImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 288,
   FQN="(anonymous namespace)::PlistDiagnostics::FlushDiagnosticsImpl", NM="_ZN12_GLOBAL__N_116PlistDiagnostics20FlushDiagnosticsImplERSt6vectorIPKN5clang4ento14PathDiagnosticESaIS6_EEPNS3_22PathDiagnosticConsumer9FilesMadeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZN12_GLOBAL__N_116PlistDiagnostics20FlushDiagnosticsImplERSt6vectorIPKN5clang4ento14PathDiagnosticESaIS6_EEPNS3_22PathDiagnosticConsumer9FilesMadeE")
  //</editor-fold>
  @Override public void FlushDiagnosticsImpl(final std.vector</*const*/ PathDiagnostic /*P*/ > /*&*/ Diags, 
                      PathDiagnosticConsumer.FilesMade /*P*/ filesMade)/* override*/ {
    raw_fd_ostream o = null;
    try {
      // Build up a set of FIDs that we use by scanning the locations and
      // ranges of the diagnostics.
      DenseMapTypeUInt<FileID> FM/*J*/= new DenseMapTypeUInt<FileID>(DenseMapInfoFileID.$Info(), 0);
      SmallVector<FileID> Fids/*J*/= new SmallVector<FileID>(10, new FileID());
      /*const*/ SourceManager /*P*/ SM = null;
      if (!Diags.empty()) {
        SM = $AddrOf(Diags.front()._path.front$Const().$arrow().getLocation().getManager());
      }
      
      for (std.vector.iterator</*const*/ PathDiagnostic /*P*/ > DI = Diags.begin(), 
          DE = Diags.end(); $noteq___normal_iterator$C(DI, DE); DI.$preInc()) {
        
        /*const*/ PathDiagnostic /*P*/ D = DI.$star();
        
        SmallVector</*const*/ PathPieces /*P*/ > WorkList/*J*/= new SmallVector</*const*/ PathPieces /*P*/ >(5, (/*const*/ PathPieces /*P*/ )null);
        WorkList.push_back($AddrOf(D._path));
        while (!WorkList.empty()) {
          final /*const*/ PathPieces /*&*/ _path = $Deref(WorkList.pop_back_val());
          
          for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = _path.begin$Const(), E = _path.end$Const(); I.$noteq(E);
               I.$preInc()) {
            /*const*/ PathDiagnosticPiece /*P*/ piece = I.$arrow().get();
            AddFID(FM, Fids, $Deref(SM), new SourceLocation(JD$Move.INSTANCE, piece.getLocation().asLocation()));
            ArrayRef<SourceRange> Ranges = piece.getRanges();
            for (type$ptr<SourceRange> I$1 = $tryClone(Ranges.begin()), 
                /*P*/ E$1 = $tryClone(Ranges.end()); $noteq_ptr(I$1, E$1); I$1.$preInc()) {
              AddFID(FM, Fids, $Deref(SM), I$1./*->*/$star().getBegin());
              AddFID(FM, Fids, $Deref(SM), I$1./*->*/$star().getEnd());
            }
            {
              
              /*const*/ PathDiagnosticCallPiece /*P*/ call = dyn_cast_PathDiagnosticCallPiece(piece);
              if ((call != null)) {
                IntrusiveRefCntPtr<PathDiagnosticEventPiece> callEnterWithin = null;
                try {
                  callEnterWithin = call.getCallEnterWithinCallerEvent();
                  if (callEnterWithin.$bool()) {
                    AddFID(FM, Fids, $Deref(SM), new SourceLocation(JD$Move.INSTANCE, callEnterWithin.$arrow().getLocation().asLocation()));
                  }
                  
                  WorkList.push_back($AddrOf(call._path));
                } finally {
                  if (callEnterWithin != null) { callEnterWithin.$destroy(); }
                }
              } else {
                /*const*/ PathDiagnosticMacroPiece /*P*/ macro = dyn_cast_PathDiagnosticMacroPiece(piece);
                if ((macro != null)) {
                  WorkList.push_back($AddrOf(macro.subPieces));
                }
              }
            }
          }
        }
      }
      
      // Open the file.
      std.error_code EC/*J*/= new std.error_code();
      o/*J*/= new raw_fd_ostream(new StringRef(OutputFile), EC, fs.OpenFlags.F_Text);
      if (EC.$bool()) {
        llvm.errs().$out(/*KEEP_STR*/"warning: could not create file: ").$out(EC.message()).$out_char($$LF);
        return;
      }
      
      EmitPlistHeader(o);
      
      // Write the root object: a <dict> containing...
      //  - "clang_version", the string representation of clang version
      //  - "files", an <array> mapping from FIDs to file names
      //  - "diagnostics", an <array> containing the path diagnostics
      o.$out(/*KEEP_STR*/"<dict>\n").$out(
          /*KEEP_STR*/" <key>clang_version</key>\n"
      );
      EmitString(o, new StringRef(getClangFullVersion())).$out_char($$LF);
      o.$out(/*KEEP_STR*/" <key>files</key>\n <array>\n");
      
      for (FileID FID : Fids)  {
        EmitString(o.$out(/*KEEP_STR*/"  "), new StringRef(SM.getFileEntryForID(/*NO_COPY*/FID).getName())).$out_char($$LF);
      }
      
      o.$out(/*KEEP_STR*/" </array>\n <key>diagnostics</key>\n <array>\n");
      
      for (std.vector.iterator</*const*/ PathDiagnostic /*P*/ > DI = Diags.begin(), 
          DE = Diags.end(); $noteq___normal_iterator$C(DI, DE); DI.$preInc()) {
        
        o.$out(/*KEEP_STR*/"  <dict>\n   <key>path</key>\n");
        
        /*const*/ PathDiagnostic /*P*/ D = DI.$star();
        
        o.$out(/*KEEP_STR*/"   <array>\n");
        
        for (std.list.iterator<IntrusiveRefCntPtr<PathDiagnosticPiece>> I = D._path.begin$Const(), E = D._path.end$Const();
             I.$noteq(E); I.$preInc())  {
          PlistDiagnosticsStatics.ReportDiag(o, I.$star().$star(), FM, $Deref(SM), LangOpts);
        }
        
        o.$out(/*KEEP_STR*/"   </array>\n");
        
        // Output the bug type and bug category.
        o.$out(/*KEEP_STR*/"   <key>description</key>");
        EmitString(o, D.getShortDescription()).$out_char($$LF);
        o.$out(/*KEEP_STR*/"   <key>category</key>");
        EmitString(o, D.getCategory()).$out_char($$LF);
        o.$out(/*KEEP_STR*/"   <key>type</key>");
        EmitString(o, D.getBugType()).$out_char($$LF);
        o.$out(/*KEEP_STR*/"   <key>check_name</key>");
        EmitString(o, D.getCheckName()).$out_char($$LF);
        
        o.$out(/*KEEP_STR*/"   <!-- This hash is experimental and going to change! -->\n");
        o.$out(/*KEEP_STR*/"   <key>issue_hash_content_of_line_in_context</key>");
        PathDiagnosticLocation UPDLoc = D.getUniqueingLoc();
        FullSourceLoc L/*J*/= new FullSourceLoc(SM.getExpansionLoc(/*NO_COPY*/UPDLoc.isValid() ? UPDLoc.asLocation() : D.getLocation().asLocation()), 
            $Deref(SM));
        /*const*/ Decl /*P*/ DeclWithIssue = D.getDeclWithIssue();
        EmitString(o, StaticanalyzerClangGlobals.GetIssueHash($Deref(SM), L, D.getCheckName(), D.getBugType(), 
                DeclWithIssue, LangOpts).$StringRef()).$out_char(
            $$LF
        );
        {
          
          // Output information about the semantic context where
          // the issue occurred.
          /*const*/ Decl /*P*/ DeclWithIssue$1 = D.getDeclWithIssue();
          if ((DeclWithIssue$1 != null)) {
            {
              // FIXME: handle blocks, which have no name.
              /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(DeclWithIssue$1);
              if ((ND != null)) {
                StringRef declKind/*J*/= new StringRef();
                switch (ND.getKind()) {
                 case CXXRecord:
                  declKind.$assignMove(/*STRINGREF_STR*/"C++ class");
                  break;
                 case CXXMethod:
                  declKind.$assignMove(/*STRINGREF_STR*/"C++ method");
                  break;
                 case ObjCMethod:
                  declKind.$assignMove(/*STRINGREF_STR*/"Objective-C method");
                  break;
                 case Function:
                  declKind.$assignMove(/*STRINGREF_STR*/"function");
                  break;
                 default:
                  break;
                }
                if (!declKind.empty()) {
                  final /*const*/std.string/*&*/ declName = ND.getDeclName().getAsString();
                  o.$out(/*KEEP_STR*/"  <key>issue_context_kind</key>");
                  EmitString(o, new StringRef(declKind)).$out_char($$LF);
                  o.$out(/*KEEP_STR*/"  <key>issue_context</key>");
                  EmitString(o, new StringRef(declName)).$out_char($$LF);
                }
                {
                  
                  // Output the bug hash for issue unique-ing. Currently, it's just an
                  // offset from the beginning of the function.
                  /*const*/ Stmt /*P*/ Body = DeclWithIssue$1.getBody();
                  if ((Body != null)) {
                    
                    // If the bug uniqueing location exists, use it for the hash.
                    // For example, this ensures that two leaks reported on the same line
                    // will have different issue_hashes and that the hash will identify
                    // the leak location even after code is added between the allocation
                    // site and the end of scope (leak report location).
                    if (UPDLoc.isValid()) {
                      FullSourceLoc UFunL/*J*/= new FullSourceLoc(SM.getExpansionLoc(D.getUniqueingDecl().getBody().getLocStart()), $Deref(SM));
                      o.$out(/*KEEP_STR*/"  <key>issue_hash_function_offset</key><string>").$out_uint(
                          L.getExpansionLineNumber() - UFunL.getExpansionLineNumber()
                      ).$out(
                          /*KEEP_STR*/"</string>\n"
                      );
                      // Otherwise, use the location on which the bug is reported.
                    } else {
                      FullSourceLoc FunL/*J*/= new FullSourceLoc(SM.getExpansionLoc(Body.getLocStart()), $Deref(SM));
                      o.$out(/*KEEP_STR*/"  <key>issue_hash_function_offset</key><string>").$out_uint(
                          L.getExpansionLineNumber() - FunL.getExpansionLineNumber()
                      ).$out(
                          /*KEEP_STR*/"</string>\n"
                      );
                    }
                  }
                }
              }
            }
          }
        }
        
        // Output the location of the bug.
        o.$out(/*KEEP_STR*/"  <key>location</key>\n");
        EmitLocation(o, $Deref(SM), new SourceLocation(JD$Move.INSTANCE, D.getLocation().asLocation()), FM, 2);
        
        // Output the diagnostic to the sub-diagnostic client, if any.
        if (!filesMade.empty()) {
          StringRef lastName/*J*/= new StringRef();
          std.vector<std.pairTypeType<StringRef, StringRef>> /*P*/ files = filesMade.getFiles($Deref(D));
          if ((files != null)) {
            for (std.vector.iterator</*const*/std.pairTypeType<StringRef, StringRef> /*P*/> CI = new std.vector.iterator</*const*/std.pairTypeType<StringRef, StringRef> /*P*/>(files.begin()), 
                CE = new std.vector.iterator</*const*/std.pairTypeType<StringRef, StringRef> /*P*/>(files.end()); $noteq___normal_iterator$C(CI, CE); CI.$preInc()) {
              StringRef newName = new StringRef(CI.$arrow().first);
              if ($noteq_StringRef(/*NO_COPY*/newName, /*NO_COPY*/lastName)) {
                if (!lastName.empty()) {
                  o.$out(/*KEEP_STR*/"  </array>\n");
                }
                lastName.$assign(newName);
                o.$out(/*KEEP_STR*/"  <key>").$out(/*NO_COPY*/lastName).$out(/*KEEP_STR*/"_files</key>\n");
                o.$out(/*KEEP_STR*/"  <array>\n");
              }
              o.$out(/*KEEP_STR*/"   <string>").$out(/*NO_COPY*/CI.$arrow().second).$out(/*KEEP_STR*/"</string>\n");
            }
            o.$out(/*KEEP_STR*/"  </array>\n");
          }
        }
        
        // Close up the entry.
        o.$out(/*KEEP_STR*/"  </dict>\n");
      }
      
      o.$out(/*KEEP_STR*/" </array>\n");
      
      // Finish.
      o.$out(/*KEEP_STR*/"</dict>\n</plist>");
    } finally {
      if (o != null) { o.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PlistDiagnostics::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 45,
   FQN="(anonymous namespace)::PlistDiagnostics::getName", NM="_ZNK12_GLOBAL__N_116PlistDiagnostics7getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZNK12_GLOBAL__N_116PlistDiagnostics7getNameEv")
  //</editor-fold>
  @Override public StringRef getName() /*const*//* override*/ {
    return new StringRef(/*KEEP_STR*/"PlistDiagnostics");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PlistDiagnostics::getGenerationScheme">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 49,
   FQN="(anonymous namespace)::PlistDiagnostics::getGenerationScheme", NM="_ZNK12_GLOBAL__N_116PlistDiagnostics19getGenerationSchemeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZNK12_GLOBAL__N_116PlistDiagnostics19getGenerationSchemeEv")
  //</editor-fold>
  @Override public PathDiagnosticConsumer.PathGenerationScheme getGenerationScheme() /*const*//* override*/ {
    return PathGenerationScheme.Extensive;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PlistDiagnostics::supportsLogicalOpControlFlow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 52,
   FQN="(anonymous namespace)::PlistDiagnostics::supportsLogicalOpControlFlow", NM="_ZNK12_GLOBAL__N_116PlistDiagnostics28supportsLogicalOpControlFlowEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZNK12_GLOBAL__N_116PlistDiagnostics28supportsLogicalOpControlFlowEv")
  //</editor-fold>
  @Override public boolean supportsLogicalOpControlFlow() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PlistDiagnostics::supportsCrossFileDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp", line = 53,
   FQN="(anonymous namespace)::PlistDiagnostics::supportsCrossFileDiagnostics", NM="_ZNK12_GLOBAL__N_116PlistDiagnostics28supportsCrossFileDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PlistDiagnostics.cpp -nm=_ZNK12_GLOBAL__N_116PlistDiagnostics28supportsCrossFileDiagnosticsEv")
  //</editor-fold>
  @Override public boolean supportsCrossFileDiagnostics() /*const*//* override*/ {
    return SupportsCrossFileDiagnostics;
  }

  
  @Override public String toString() {
    return "" + "OutputFile=" + OutputFile // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + ", SupportsCrossFileDiagnostics=" + SupportsCrossFileDiagnostics // NOI18N
              + super.toString(); // NOI18N
  }
}
