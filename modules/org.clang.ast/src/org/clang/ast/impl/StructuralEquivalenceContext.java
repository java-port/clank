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

package org.clang.ast.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;        
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StructuralEquivalenceContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 292,
 FQN="(anonymous namespace)::StructuralEquivalenceContext", NM="_ZN12_GLOBAL__N_128StructuralEquivalenceContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN12_GLOBAL__N_128StructuralEquivalenceContextE")
//</editor-fold>
public class/*struct*/ StructuralEquivalenceContext implements Destructors.ClassWithDestructor {
  /// \brief AST contexts for which we are checking structural equivalence.
  public final ASTContext /*&*/ C1;
  public final ASTContext /*&*/ C2;
  
  /// \brief The set of "tentative" equivalences between two canonical 
  /// declarations, mapping from a declaration in the first context to the
  /// declaration in the second context that we believe to be equivalent.
  public DenseMap<Decl /*P*/ , Decl /*P*/ > TentativeEquivalences;
  
  /// \brief Queue of declarations in the first context whose equivalence
  /// with a declaration in the second context still needs to be verified.
  public std.deque<Decl /*P*/ > DeclsToCheck;
  
  /// \brief Declaration (from, to) pairs that are known not to be equivalent
  /// (which we have already complained about).
  public final DenseSet<std.pair<Decl /*P*/ , Decl /*P*/ > > /*&*/ NonEquivalentDecls;
  
  /// \brief Whether we're being strict about the spelling of types when 
  /// unifying two types.
  public boolean StrictTypeSpelling;
  
  /// \brief Whether to complain about failures.
  public boolean Complain;
  
  /// \brief \c true if the last diagnostic came from C2.
  public boolean LastDiagFromC2;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StructuralEquivalenceContext::StructuralEquivalenceContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 319,
   FQN="(anonymous namespace)::StructuralEquivalenceContext::StructuralEquivalenceContext", NM="_ZN12_GLOBAL__N_128StructuralEquivalenceContextC1ERN5clang10ASTContextES3_RN4llvm8DenseSetISt4pairIPNS1_4DeclES8_ENS4_12DenseMapInfoIS9_EEEEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN12_GLOBAL__N_128StructuralEquivalenceContextC1ERN5clang10ASTContextES3_RN4llvm8DenseSetISt4pairIPNS1_4DeclES8_ENS4_12DenseMapInfoIS9_EEEEbb")
  //</editor-fold>
  public StructuralEquivalenceContext(final ASTContext /*&*/ C1, final ASTContext /*&*/ C2, 
      final DenseSet<std.pair<Decl /*P*/ , Decl /*P*/ > > /*&*/ NonEquivalentDecls) {
    this(C1, C2, 
      NonEquivalentDecls, 
      false, 
      true);
  }
  public StructuralEquivalenceContext(final ASTContext /*&*/ C1, final ASTContext /*&*/ C2, 
      final DenseSet<std.pair<Decl /*P*/ , Decl /*P*/ > > /*&*/ NonEquivalentDecls, 
      boolean StrictTypeSpelling/*= false*/) {
    this(C1, C2, 
      NonEquivalentDecls, 
      StrictTypeSpelling, 
      true);
  }
  public StructuralEquivalenceContext(final ASTContext /*&*/ C1, final ASTContext /*&*/ C2, 
      final DenseSet<std.pair<Decl /*P*/ , Decl /*P*/ > > /*&*/ NonEquivalentDecls, 
      boolean StrictTypeSpelling/*= false*/, 
      boolean Complain/*= true*/) {
    // : C1(C1), C2(C2), TentativeEquivalences(), DeclsToCheck(), NonEquivalentDecls(NonEquivalentDecls), StrictTypeSpelling(StrictTypeSpelling), Complain(Complain), LastDiagFromC2(false) 
    //START JInit
    this./*&*/C1=/*&*/C1;
    this./*&*/C2=/*&*/C2;
    this.TentativeEquivalences = new DenseMap<Decl /*P*/ , Decl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Decl /*P*/ )null);
    this.DeclsToCheck = new std.deque<Decl /*P*/ >(true);
    this./*&*/NonEquivalentDecls=/*&*/NonEquivalentDecls;
    this.StrictTypeSpelling = StrictTypeSpelling;
    this.Complain = Complain;
    this.LastDiagFromC2 = false;
    //END JInit
  }

  
  /// \brief Determine whether the two declarations are structurally
  /// equivalent.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StructuralEquivalenceContext::IsStructurallyEquivalent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1415,
   FQN="(anonymous namespace)::StructuralEquivalenceContext::IsStructurallyEquivalent", NM="_ZN12_GLOBAL__N_128StructuralEquivalenceContext24IsStructurallyEquivalentEPN5clang4DeclES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN12_GLOBAL__N_128StructuralEquivalenceContext24IsStructurallyEquivalentEPN5clang4DeclES3_")
  //</editor-fold>
  public boolean IsStructurallyEquivalent(Decl /*P*/ D1, 
                          Decl /*P*/ D2) {
    if (!/*::*/ASTImporterStatics.IsStructurallyEquivalent(/*Deref*/this, D1, D2)) {
      return false;
    }
    
    return !Finish();
  }

  
  /// \brief Determine whether the two types are structurally equivalent.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StructuralEquivalenceContext::IsStructurallyEquivalent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1423,
   FQN="(anonymous namespace)::StructuralEquivalenceContext::IsStructurallyEquivalent", NM="_ZN12_GLOBAL__N_128StructuralEquivalenceContext24IsStructurallyEquivalentEN5clang8QualTypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN12_GLOBAL__N_128StructuralEquivalenceContext24IsStructurallyEquivalentEN5clang8QualTypeES2_")
  //</editor-fold>
  public boolean IsStructurallyEquivalent(QualType T1, 
                          QualType T2) {
    if (!/*::*/ASTImporterStatics.IsStructurallyEquivalent(/*Deref*/this, new QualType(T1), new QualType(T2))) {
      return false;
    }
    
    return !Finish();
  }

/*private:*/
  /// \brief Finish checking all of the structural equivalences.
  ///
  /// \returns true if an error occurred, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StructuralEquivalenceContext::Finish">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1431,
   FQN="(anonymous namespace)::StructuralEquivalenceContext::Finish", NM="_ZN12_GLOBAL__N_128StructuralEquivalenceContext6FinishEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN12_GLOBAL__N_128StructuralEquivalenceContext6FinishEv")
  //</editor-fold>
  private boolean Finish() {
    while (!DeclsToCheck.empty()) {
      // Check the next declaration.
      Decl /*P*/ D1 = DeclsToCheck.front();
      DeclsToCheck.pop_front();
      
      Decl /*P*/ D2 = TentativeEquivalences.$at_T1$C$R(D1);
      assert ((D2 != null)) : "Unrecorded tentative equivalence?";
      
      boolean Equivalent = true;
      {
        
        // FIXME: Switch on all declaration kinds. For now, we're just going to
        // check the obvious ones.
        RecordDecl /*P*/ Record1 = dyn_cast_RecordDecl(D1);
        if ((Record1 != null)) {
          {
            RecordDecl /*P*/ Record2 = dyn_cast_RecordDecl(D2);
            if ((Record2 != null)) {
              // Check for equivalent structure names.
              IdentifierInfo /*P*/ Name1 = Record1.getIdentifier();
              if (!(Name1 != null) && (Record1.getTypedefNameForAnonDecl() != null)) {
                Name1 = Record1.getTypedefNameForAnonDecl().getIdentifier();
              }
              IdentifierInfo /*P*/ Name2 = Record2.getIdentifier();
              if (!(Name2 != null) && (Record2.getTypedefNameForAnonDecl() != null)) {
                Name2 = Record2.getTypedefNameForAnonDecl().getIdentifier();
              }
              if (!/*::*/ASTImporterStatics.IsStructurallyEquivalent(Name1, Name2)
                 || !/*::*/ASTImporterStatics.IsStructurallyEquivalent(/*Deref*/this, Record1, Record2)) {
                Equivalent = false;
              }
            } else {
              // Record/non-record mismatch.
              Equivalent = false;
            }
          }
        } else {
          EnumDecl /*P*/ Enum1 = dyn_cast_EnumDecl(D1);
          if ((Enum1 != null)) {
            {
              EnumDecl /*P*/ Enum2 = dyn_cast_EnumDecl(D2);
              if ((Enum2 != null)) {
                // Check for equivalent enum names.
                IdentifierInfo /*P*/ Name1 = Enum1.getIdentifier();
                if (!(Name1 != null) && (Enum1.getTypedefNameForAnonDecl() != null)) {
                  Name1 = Enum1.getTypedefNameForAnonDecl().getIdentifier();
                }
                IdentifierInfo /*P*/ Name2 = Enum2.getIdentifier();
                if (!(Name2 != null) && (Enum2.getTypedefNameForAnonDecl() != null)) {
                  Name2 = Enum2.getTypedefNameForAnonDecl().getIdentifier();
                }
                if (!/*::*/ASTImporterStatics.IsStructurallyEquivalent(Name1, Name2)
                   || !/*::*/ASTImporterStatics.IsStructurallyEquivalent(/*Deref*/this, Enum1, Enum2)) {
                  Equivalent = false;
                }
              } else {
                // Enum/non-enum mismatch
                Equivalent = false;
              }
            }
          } else {
            TypedefNameDecl /*P*/ Typedef1 = dyn_cast_TypedefNameDecl(D1);
            if ((Typedef1 != null)) {
              {
                TypedefNameDecl /*P*/ Typedef2 = dyn_cast_TypedefNameDecl(D2);
                if ((Typedef2 != null)) {
                  if (!/*::*/ASTImporterStatics.IsStructurallyEquivalent(Typedef1.getIdentifier(), 
                      Typedef2.getIdentifier())
                     || !/*::*/ASTImporterStatics.IsStructurallyEquivalent(/*Deref*/this, 
                      Typedef1.getUnderlyingType(), 
                      Typedef2.getUnderlyingType())) {
                    Equivalent = false;
                  }
                } else {
                  // Typedef/non-typedef mismatch.
                  Equivalent = false;
                }
              }
            } else {
              ClassTemplateDecl /*P*/ ClassTemplate1 = dyn_cast_ClassTemplateDecl(D1);
              if ((ClassTemplate1 != null)) {
                {
                  ClassTemplateDecl /*P*/ ClassTemplate2 = dyn_cast_ClassTemplateDecl(D2);
                  if ((ClassTemplate2 != null)) {
                    if (!/*::*/ASTImporterStatics.IsStructurallyEquivalent(ClassTemplate1.getIdentifier(), 
                        ClassTemplate2.getIdentifier())
                       || !/*::*/ASTImporterStatics.IsStructurallyEquivalent(/*Deref*/this, ClassTemplate1, ClassTemplate2)) {
                      Equivalent = false;
                    }
                  } else {
                    // Class template/non-class-template mismatch.
                    Equivalent = false;
                  }
                }
              } else {
                TemplateTypeParmDecl /*P*/ TTP1 = dyn_cast_TemplateTypeParmDecl(D1);
                if ((TTP1 != null)) {
                  {
                    TemplateTypeParmDecl /*P*/ TTP2 = dyn_cast_TemplateTypeParmDecl(D2);
                    if ((TTP2 != null)) {
                      if (!/*::*/ASTImporterStatics.IsStructurallyEquivalent(/*Deref*/this, TTP1, TTP2)) {
                        Equivalent = false;
                      }
                    } else {
                      // Kind mismatch.
                      Equivalent = false;
                    }
                  }
                } else {
                  NonTypeTemplateParmDecl /*P*/ NTTP1 = dyn_cast_NonTypeTemplateParmDecl(D1);
                  if ((NTTP1 != null)) {
                    {
                      NonTypeTemplateParmDecl /*P*/ NTTP2 = dyn_cast_NonTypeTemplateParmDecl(D2);
                      if ((NTTP2 != null)) {
                        if (!/*::*/ASTImporterStatics.IsStructurallyEquivalent(/*Deref*/this, NTTP1, NTTP2)) {
                          Equivalent = false;
                        }
                      } else {
                        // Kind mismatch.
                        Equivalent = false;
                      }
                    }
                  } else {
                    TemplateTemplateParmDecl /*P*/ TTP1$1 = dyn_cast_TemplateTemplateParmDecl(D1);
                    if ((TTP1$1 != null)) {
                      {
                        TemplateTemplateParmDecl /*P*/ TTP2 = dyn_cast_TemplateTemplateParmDecl(D2);
                        if ((TTP2 != null)) {
                          if (!/*::*/ASTImporterStatics.IsStructurallyEquivalent(/*Deref*/this, TTP1$1, TTP2)) {
                            Equivalent = false;
                          }
                        } else {
                          // Kind mismatch.
                          Equivalent = false;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (!Equivalent) {
        // Note that these two declarations are not equivalent (and we already
        // know about it).
        NonEquivalentDecls.insert(std.make_pair_Ptr_Ptr(D1.getCanonicalDecl(), 
                D2.getCanonicalDecl()));
        return true;
      }
      // FIXME: Check other declaration kinds!
    }
    
    return false;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StructuralEquivalenceContext::Diag1">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 341,
   FQN="(anonymous namespace)::StructuralEquivalenceContext::Diag1", NM="_ZN12_GLOBAL__N_128StructuralEquivalenceContext5Diag1EN5clang14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN12_GLOBAL__N_128StructuralEquivalenceContext5Diag1EN5clang14SourceLocationEj")
  //</editor-fold>
  public DiagnosticBuilder Diag1(SourceLocation Loc, /*uint*/int DiagID) {
    assert (Complain) : "Not allowed to complain";
    if (LastDiagFromC2) {
      C1.getDiagnostics().notePriorDiagnosticFrom(C2.getDiagnostics());
    }
    LastDiagFromC2 = false;
    return C1.getDiagnostics().Report(/*NO_COPY*/Loc, DiagID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StructuralEquivalenceContext::Diag2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 349,
   FQN="(anonymous namespace)::StructuralEquivalenceContext::Diag2", NM="_ZN12_GLOBAL__N_128StructuralEquivalenceContext5Diag2EN5clang14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN12_GLOBAL__N_128StructuralEquivalenceContext5Diag2EN5clang14SourceLocationEj")
  //</editor-fold>
  public DiagnosticBuilder Diag2(SourceLocation Loc, /*uint*/int DiagID) {
    assert (Complain) : "Not allowed to complain";
    if (!LastDiagFromC2) {
      C2.getDiagnostics().notePriorDiagnosticFrom(C1.getDiagnostics());
    }
    LastDiagFromC2 = true;
    return C2.getDiagnostics().Report(/*NO_COPY*/Loc, DiagID);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StructuralEquivalenceContext::~StructuralEquivalenceContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 292,
   FQN="(anonymous namespace)::StructuralEquivalenceContext::~StructuralEquivalenceContext", NM="_ZN12_GLOBAL__N_128StructuralEquivalenceContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZN12_GLOBAL__N_128StructuralEquivalenceContextD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    DeclsToCheck.$destroy();
    TentativeEquivalences.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "C1=" + "[ASTContext]" // NOI18N
              + ", C2=" + "[ASTContext]" // NOI18N
              + ", TentativeEquivalences=" + TentativeEquivalences // NOI18N
              + ", DeclsToCheck=" + DeclsToCheck // NOI18N
              + ", NonEquivalentDecls=" + NonEquivalentDecls // NOI18N
              + ", StrictTypeSpelling=" + StrictTypeSpelling // NOI18N
              + ", Complain=" + Complain // NOI18N
              + ", LastDiagFromC2=" + LastDiagFromC2; // NOI18N
  }
}
